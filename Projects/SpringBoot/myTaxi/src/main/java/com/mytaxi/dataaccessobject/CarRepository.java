package com.mytaxi.dataaccessobject;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainvalue.CarStatus;
import com.mytaxi.domainvalue.Ratings;

/**
 * Database Access Object for cars table.
 * <p/>
 */
@Repository("carRepository")
public interface CarRepository extends JpaRepository<CarDO, Long>
{
    List<CarDO> findByCarStatus(CarStatus carStatus);
    
    List<CarDO> findByLicensePlate(String licensePlate);
    
    List<CarDO> findByRating(Ratings rating);
}
