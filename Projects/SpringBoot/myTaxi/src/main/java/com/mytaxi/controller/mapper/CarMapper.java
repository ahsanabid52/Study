package com.mytaxi.controller.mapper;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.mytaxi.datatransferobject.CarDTO;
import com.mytaxi.domainobject.CarDO;

public class CarMapper
{
    public static CarDO makeCarDO(CarDTO carDTO)
    {
        return new CarDO(carDTO.getLicensePlate(), carDTO.getName(), carDTO.getCarStatus());
    }


    public static CarDO makeCarDOUI(CarDTO carDTO)
    {

        return new CarDO(
            carDTO.getId(), carDTO.getName(), carDTO.getModelYear(), ZonedDateTime.now(), carDTO.getLicensePlate(), carDTO.getManufacturedIn(),
            carDTO.getCompanyName(), carDTO.getSeatCount(), carDTO.getDoorsCount(), carDTO.getConvertible(), carDTO.getRating(), carDTO.getEngineType(),

            carDTO.getDeleted(), carDTO.getCarStatus());
    }


    public static CarDTO makeCarDTO(CarDO carDO)
    {
        CarDTO.CarDTOBuilder carDTOBuilder =
            CarDTO
                .newBuilder()
                .setId(carDO.getId())
                .setName(carDO.getName())
                .setLicensePlate(carDO.getLicensePlate())
                .setCarStatus(carDO.getCarStatus())
                .setDeleted(carDO.getDeleted())
                .setManufacturedIn(carDO.getManufacturedIn())
                .setModelYear(carDO.getModelYear())
                .setCompanyName(carDO.getCompanyName())
                .setRating(carDO.getRating())
                .setSeatCount(carDO.getSeatCount())
                .setDoorsCount(carDO.getDoorsCount())
                .setConvertible(carDO.getConvertible())
                .setEngineType(carDO.getEngineType());

        return carDTOBuilder.createCarDTO();
    }


    public static List<CarDTO> makeCarDTOList(Collection<CarDO> cars)
    {
        return cars
            .stream()
            .map(CarMapper::makeCarDTO)
            .collect(Collectors.toList());
    }


    public static CarDTO makeEmptyCarDTO()
    {
        CarDTO.CarDTOBuilder carDTOBuilder = CarDTO.newBuilder();
        return carDTOBuilder.createCarDTO();
    }
}