package com.mytaxi.service.driver;

import java.util.List;

import com.mytaxi.datatransferobject.ResponseDTO;
import com.mytaxi.domainobject.DriverDO;
import com.mytaxi.domainvalue.OnlineStatus;
import com.mytaxi.exception.CarAlreadyInUseException;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;

public interface DriverService
{

    DriverDO create(DriverDO driverDO) throws ConstraintsViolationException;


    void delete(Long driverId) throws EntityNotFoundException;


    void updateLocation(long driverId, double longitude, double latitude) throws EntityNotFoundException;


    DriverDO find(Long driverId) throws EntityNotFoundException;


    List<DriverDO> find(OnlineStatus onlineStatus);


    List<DriverDO> find(String username);


    List<DriverDO> findAllDrivers();


    ResponseDTO selectCar(long driverId, long carId) throws EntityNotFoundException, CarAlreadyInUseException;


    ResponseDTO deselectCar(long driverId, long carId) throws EntityNotFoundException;

}