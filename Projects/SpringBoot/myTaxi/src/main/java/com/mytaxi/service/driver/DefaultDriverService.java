package com.mytaxi.service.driver;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mytaxi.dataaccessobject.DriverRepository;
import com.mytaxi.datatransferobject.ResponseDTO;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainobject.DriverDO;
import com.mytaxi.domainvalue.CarStatus;
import com.mytaxi.domainvalue.GeoCoordinate;
import com.mytaxi.domainvalue.OnlineStatus;
import com.mytaxi.exception.CarAlreadyInUseException;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;
import com.mytaxi.service.car.CarService;

/**
 * Service to encapsulate the link between DAO and controller and to have business logic for some driver specific things.
 * <p/>
 */
@Service
public class DefaultDriverService implements DriverService
{

    private static final Logger LOG = LoggerFactory.getLogger(DefaultDriverService.class);

    private final DriverRepository driverRepository;

    private final CarService carService;


    public DefaultDriverService(final DriverRepository driverRepository, CarService carService)
    {
        this.driverRepository = driverRepository;
        this.carService = carService;
    }


    /**
     * Selects a driver by id.
     *
     * @param driverId
     * @return found driver
     * @throws EntityNotFoundException if no driver with the given id was found.
     */
    @Override
    public DriverDO find(Long driverId) throws EntityNotFoundException
    {
        return findDriverChecked(driverId);
    }


    /**
     * Creates a new driver.
     *
     * @param driverDO
     * @return
     * @throws ConstraintsViolationException if a driver already exists with the given username, ... .
     */
    @Override
    public DriverDO create(DriverDO driverDO) throws ConstraintsViolationException
    {
        DriverDO driver;
        try
        {
            driver = driverRepository.save(driverDO);
        }
        catch (DataIntegrityViolationException e)
        {
            LOG.warn("ConstraintsViolationException while creating a driver: {}", driverDO, e);
            throw new ConstraintsViolationException(e.getMessage());
        }
        return driver;
    }


    /**
     * Deletes an existing driver by id.
     *
     * @param driverId
     * @throws EntityNotFoundException if no driver with the given id was found.
     */
    @Override
    @Transactional
    public void delete(Long driverId) throws EntityNotFoundException
    {
        DriverDO driverDO = findDriverChecked(driverId);
        driverDO.setDeleted(true);
    }


    /**
     * Update the location for a driver.
     *
     * @param driverId
     * @param longitude
     * @param latitude
     * @throws EntityNotFoundException
     */
    @Override
    @Transactional
    public void updateLocation(long driverId, double longitude, double latitude) throws EntityNotFoundException
    {
        DriverDO driverDO = findDriverChecked(driverId);
        driverDO.setCoordinate(new GeoCoordinate(latitude, longitude));
    }


    /**
     * Find all drivers by online state.
     *
     * @param onlineStatus
     */
    @Override
    public List<DriverDO> find(OnlineStatus onlineStatus)
    {
        return driverRepository.findByOnlineStatus(onlineStatus);
    }


    /**
     * Finds all the drivers.
     *
     * @param onlineStatus
     */    @Override
    public List<DriverDO> findAllDrivers()
    {
        return (List<DriverDO>) driverRepository.findAll();
    }


    private DriverDO findDriverChecked(Long driverId) throws EntityNotFoundException
    {
        return driverRepository
            .findById(driverId)
            .orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " + driverId));
    }

    /**
     * Driver selects a car by its id.
     *
     * @param onlineStatus
     */
    @Override
    public ResponseDTO selectCar(long driverId, long carId) throws EntityNotFoundException, CarAlreadyInUseException
    {
        ResponseDTO resp = new ResponseDTO();
        DriverDO driverDO = findDriverChecked(driverId);
        if (OnlineStatus.OFFLINE.equals(driverDO.getOnlineStatus()))
        {
            resp.setResponeCode("-001");
            resp.setResponseDescription("Driver is offline.");
            return resp;
        }
        CarDO carById = carService.find(carId);

        if (CarStatus.ON_THE_ROAD.equals(carById.getCarStatus()))
        {
            /*Commented as now sending an error to the screen.*/
            //            throw new CarAlreadyInUseException("Car is already in use by some other driver.");  
            resp.setResponeCode("-003");
            resp.setResponseDescription("Car is already in use by some other driver.");
            return resp;
        }

        carService.updateCarStatus(carId, CarStatus.ON_THE_ROAD);
        driverDO.setCarSelectedId(carById);
        driverRepository.save(driverDO);

        resp.setResponeCode("000");
        resp.setResponseDescription("Car is selected by the driver.");

        return resp;
    }

    /**
     * Driver deselects a car by its id.
     *
     * @param driverId
     * @param carId
     */
    @Override
    public ResponseDTO deselectCar(long driverId, long carId) throws EntityNotFoundException
    {
        ResponseDTO resp = new ResponseDTO();
        DriverDO driverDO = findDriverChecked(driverId);

        if (OnlineStatus.OFFLINE.equals(driverDO.getOnlineStatus())
            || null == driverDO.getCarSelectedId()
            || driverDO.getCarSelectedId().getId() != carId)
        {
            resp.setResponeCode("-001");
            resp.setResponseDescription("Driver cannot deselect the car.");
            return resp;
        }

        carService.updateCarStatus(carId, CarStatus.AVAILABLE);
        driverDO.setCarSelectedId(null);
        driverRepository.save(driverDO);
        resp.setResponeCode("000");
        resp.setResponseDescription("Car is deselected by the driver.");

        return resp;

    }


    /**
     * Find all drivers by the provided username.
     *
     * @param username
     */
    @Override
    public List<DriverDO> find(String username)
    {
        return driverRepository.findByUsername(username);
    }
}