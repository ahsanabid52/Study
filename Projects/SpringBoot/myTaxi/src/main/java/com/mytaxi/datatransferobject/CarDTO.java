package com.mytaxi.datatransferobject;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mytaxi.domainvalue.CarStatus;
import com.mytaxi.domainvalue.EngineType;
import com.mytaxi.domainvalue.Ratings;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDTO
{
    @JsonIgnore
    private Long id;

    @NotNull(message = "Name can not be null!")
    private String name;

    @NotNull(message = "License Plate can not be null!")
    private String licensePlate;

    @NotNull(message = "Car Status can not be null!")
    private CarStatus carStatus;

    private Ratings rating;
    private Boolean deleted = false;
    private String modelYear;
    private String manufacturedIn;
    private String companyName;

    private int seatCount;
    private int doorsCount;
    private Boolean convertible;
    private EngineType engineType;


    private CarDTO()
    {}


    private CarDTO(
        Long id, String name, String licensePlate, CarStatus carStatus, Boolean deleted, Ratings ratings,
        String modelYear,
        String manufacturedIn,
        String companyName, int seatCount,
        int doorsCount,
        Boolean convertible,
        EngineType engineType

    )
    {
        this.id = id;
        this.name = name;
        this.licensePlate = licensePlate;
        this.carStatus = carStatus;
        this.deleted = deleted;
        this.rating = ratings;
        this.modelYear = modelYear;
        this.manufacturedIn = manufacturedIn;
        this.companyName = companyName;
        this.seatCount = seatCount;
        this.doorsCount = doorsCount;
        this.convertible = convertible;
        this.engineType = engineType;
    }


    public static CarDTOBuilder newBuilder()
    {
        return new CarDTOBuilder();
    }


    @JsonProperty
    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


    public void setLicensePlate(String licensePlate)
    {
        this.licensePlate = licensePlate;
    }


    public void setName(String name)
    {
        this.name = name;
    }


    public String getLicensePlate()
    {
        return licensePlate;
    }


    public String getName()
    {
        return name;
    }


    public CarStatus getCarStatus()
    {
        return carStatus;
    }


    public Boolean getDeleted()
    {
        return deleted;
    }


    public void setCarStatus(CarStatus carStatus)
    {
        this.carStatus = carStatus;
    }


    public void setDeleted(Boolean deleted)
    {
        this.deleted = deleted;
    }


    public void setRating(Ratings rating)
    {
        this.rating = rating;
    }


    public Ratings getRating()
    {
        return rating;
    }


    public String getModelYear()
    {
        return modelYear;
    }


    public void setModelYear(String modelYear)
    {
        this.modelYear = modelYear;
    }


    public String getManufacturedIn()
    {
        return manufacturedIn;
    }


    public void setManufacturedIn(String manufacturedIn)
    {
        this.manufacturedIn = manufacturedIn;
    }


    public String getCompanyName()
    {
        return companyName;
    }


    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }


    public int getSeatCount()
    {
        return seatCount;
    }


    public void setSeatCount(int seatCount)
    {
        this.seatCount = seatCount;
    }


    public int getDoorsCount()
    {
        return doorsCount;
    }


    public void setDoorsCount(int doorsCount)
    {
        this.doorsCount = doorsCount;
    }


    public Boolean getConvertible()
    {
        return convertible;
    }


    public void setConvertible(Boolean convertible)
    {
        this.convertible = convertible;
    }


    public EngineType getEngineType()
    {
        return engineType;
    }


    public void setEngineType(EngineType engineType)
    {
        this.engineType = engineType;
    }

    public static class CarDTOBuilder
    {

        private Long id;
        private String name;
        private String licensePlate;
        private CarStatus carStatus;
        private Ratings rating;
        private Boolean deleted = false;
        private String modelYear;
        private String manufacturedIn;
        private String companyName;
        private int seatCount;
        private int doorsCount;
        private Boolean convertible;
        private EngineType engineType;


        public CarDTOBuilder setId(Long id)
        {
            this.id = id;
            return this;
        }


        public CarDTOBuilder setName(String name)
        {
            this.name = name;
            return this;
        }


        public CarDTOBuilder setLicensePlate(String licensePlate)
        {
            this.licensePlate = licensePlate;
            return this;
        }


        public CarDTOBuilder setCarStatus(CarStatus carStatus)
        {
            this.carStatus = carStatus;
            return this;
        }


        public CarDTOBuilder setDeleted(Boolean deleted)
        {
            this.deleted = deleted;
            return this;
        }


        public CarDTOBuilder setRating(Ratings rating)
        {
            this.rating = rating;
            return this;
        }


        public CarDTOBuilder setModelYear(String modelYear)
        {
            this.modelYear = modelYear;
            return this;
        }


        public CarDTOBuilder setManufacturedIn(String manufacturedIn)
        {
            this.manufacturedIn = manufacturedIn;
            return this;
        }


        public CarDTOBuilder setCompanyName(String companyName)
        {
            this.companyName = companyName;
            return this;
        }


        public CarDTOBuilder setSeatCount(int seatCount)
        {
            this.seatCount = seatCount;
            return this;
        }


        public CarDTOBuilder setDoorsCount(int doorsCount)
        {
            this.doorsCount = doorsCount;
            return this;
        }


        public CarDTOBuilder setConvertible(Boolean convertible)
        {
            this.convertible = convertible;
            return this;
        }


        public CarDTOBuilder setEngineType(EngineType engineType)
        {
            this.engineType = engineType;
            return this;
        }


        public CarDTO createCarDTO()
        {

            return new CarDTO(id, name, licensePlate, carStatus, deleted, rating, modelYear, manufacturedIn, companyName, seatCount, doorsCount, convertible, engineType);
        }
    }
}
