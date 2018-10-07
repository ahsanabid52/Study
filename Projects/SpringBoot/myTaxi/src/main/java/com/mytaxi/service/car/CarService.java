package com.mytaxi.service.car;

import java.util.List;

import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainvalue.CarStatus;
import com.mytaxi.domainvalue.Ratings;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;

public interface CarService
{

    CarDO create(CarDO carDO) throws ConstraintsViolationException;


    void delete(Long carId) throws EntityNotFoundException;


    CarDO find(Long carId) throws EntityNotFoundException;


    List<CarDO> findByCarStatus(CarStatus carStatus);


    List<CarDO> findByLicensePlate(String licensePlate);


    List<CarDO> findByRating(Ratings rating);


    List<CarDO> findAllCars();


    void updateCarStatus(long carId, CarStatus carStatus) throws EntityNotFoundException;

}