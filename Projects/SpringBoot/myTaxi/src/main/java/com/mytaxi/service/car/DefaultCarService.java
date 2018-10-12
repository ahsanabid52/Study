package com.mytaxi.service.car;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mytaxi.dataaccessobject.CarRepository;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainvalue.CarStatus;
import com.mytaxi.domainvalue.Ratings;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;

/**
 * Service to encapsulate the link between DAO and controller and to have business logic for some cars specific things.
 * <p/>
 */
@Service
public class DefaultCarService implements CarService
{

    private static final Logger LOG = LoggerFactory.getLogger(DefaultCarService.class);

    private final CarRepository carRepository;


    public DefaultCarService(final CarRepository carRepository)
    {
        this.carRepository = carRepository;
    }


    /**
     * Selects a car by id.
     *
     * @param car
     * @return found car
     * @throws EntityNotFoundException if no car with the given id was found.
     */
    @Override
    public CarDO find(Long carId) throws EntityNotFoundException
    {
        return findByCarIdChecked(carId);
    }


    /**
     * Creates a new car.
     *
     * @param CarDO
     * @return
     * @throws ConstraintsViolationException if a car already exists with the given name.
     */
    @Override
    public CarDO create(CarDO carDO) throws ConstraintsViolationException
    {
        CarDO car;
        try
        {
            car = carRepository.save(carDO);
        }
        catch (DataIntegrityViolationException e)
        {
            LOG.warn("ConstraintsViolationException while creating a car: {}", carDO, e);
            throw new ConstraintsViolationException(e.getMessage());
        }
        return car;
    }


    /**
     * Deletes an existing car by id.
     *
     * @param carId
     * @throws EntityNotFoundException if no car with the given id was found.
     */
    @Override
    @Transactional
    public void delete(Long carId) throws EntityNotFoundException
    {
        CarDO carDO = findByCarIdChecked(carId);
        carDO.setDeleted(true);
    }


    private CarDO findByCarIdChecked(Long carId) throws EntityNotFoundException
    {
        return carRepository
            .findById(carId)
            .orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " + carId));
    }


    /**
     * Find all drivers by online state.
     *
     * @param onlineStatus
     */
    @Override
    public List<CarDO> findByCarStatus(CarStatus carStatus)
    {
        return carRepository.findByCarStatus(carStatus);
    }


    /**
     * Updates the carStatus/availability of the .
     *
     * @param carId
     * @param carStatus
     * @throws EntityNotFoundException
     */
    @Override
    @Transactional
    public void updateCarStatus(long carId, CarStatus carStatus) throws EntityNotFoundException
    {
        CarDO carDO = findByCarIdChecked(carId);
        carDO.setCarStatus(carStatus);
    }


    @Override
    public List<CarDO> findAllCars()
    {
        return carRepository.findAll();
    }


    @Override
    public List<CarDO> findByLicensePlate(String licensePlate)
    {
        return carRepository.findByLicensePlate(licensePlate);
    }


    @Override
    public List<CarDO> findByRating(Ratings rating)
    {
        return carRepository.findByRating(rating);
    }
}