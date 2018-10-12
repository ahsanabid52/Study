package com.mytaxi.domainobject;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.mytaxi.domainvalue.CarStatus;
import com.mytaxi.domainvalue.EngineType;
import com.mytaxi.domainvalue.Ratings;

@Entity
@Table(
    name = "car",
    uniqueConstraints = @UniqueConstraint(name = "uc_id", columnNames = {"id"})
    )
public class CarDO
{
    @Id
    @SequenceGenerator(name = "seqC", initialValue = 1, allocationSize = 1, sequenceName = "seqC" )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqC")
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Name can not be null!")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "Model Year can not be null!")
    private String modelYear;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated = ZonedDateTime.now();

    @Column(nullable = false)
    @NotNull(message = "License Plate can not be null!")
    private String licensePlate;

    @Column(nullable = false)
    @NotNull(message = "Manufactured In can not be null!")
    private String manufacturedIn;

    @Column(nullable = false)
    @NotNull(message = "Manufacturing Company Name can not be null!")
    private String companyName;

    @Column(nullable = false)
    private int seatCount = 4; /* Using 4 as a default seat Count.*/

    @Column(nullable = false)
    private int doorsCount = 4; /* Using 4 as a default doors Count.*/

    @Column(nullable = false)
    private Boolean convertible = false; /* Using not convertible as a default.*/

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Ratings rating;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EngineType engineType;

    @Column(nullable = false)
    private Boolean deleted = false;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CarStatus carStatus;

 
    private CarDO()
    {}


    public CarDO(String name, String licensePlate, CarStatus carStatus)
    {
        this.name = name;
        this.licensePlate = licensePlate;
        this.deleted = false;
        this.rating = Ratings.DEFAULT;
        this.engineType = EngineType.GAS;
        this.carStatus = carStatus;
    }


    public CarDO(
        Long id, String name, String modelYear, ZonedDateTime dateCreated,
        String licensePlate, String manufacturedIn,
        String companyName, int seatCount, int doorsCount, Boolean convertible, Ratings rating,
        EngineType engineType, Boolean deleted, CarStatus carStatus)
    {
        super();
        this.id = id;
        this.name = name;
        this.modelYear = modelYear;
        this.dateCreated = dateCreated;
        this.licensePlate = licensePlate;
        this.manufacturedIn = manufacturedIn;
        this.companyName = companyName;
        this.seatCount = seatCount;
        this.doorsCount = doorsCount;
        this.convertible = convertible;
        this.rating = rating;
        this.engineType = engineType;
        this.deleted = deleted;
        this.carStatus = carStatus;
    }


    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


    public String getName()
    {
        return name;
    }


    public void setName(String name)
    {
        this.name = name;
    }


    public String getModelYear()
    {
        return modelYear;
    }


    public void setModelYear(String modelYear)
    {
        this.modelYear = modelYear;
    }


    public ZonedDateTime getDateCreated()
    {
        return dateCreated;
    }


    public void setDateCreated(ZonedDateTime dateCreated)
    {
        this.dateCreated = dateCreated;
    }


    public String getLicensePlate()
    {
        return licensePlate;
    }


    public void setLicensePlate(String licensePlate)
    {
        this.licensePlate = licensePlate;
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


    public Ratings getRating()
    {
        return rating;
    }


    public void setRating(Ratings rating)
    {
        this.rating = rating;
    }


    public EngineType getEngineType()
    {
        return engineType;
    }


    public void setEngineType(EngineType engineType)
    {
        this.engineType = engineType;
    }


    public Boolean getDeleted()
    {
        return deleted;
    }


    public void setDeleted(Boolean deleted)
    {
        this.deleted = deleted;
    }


    public CarStatus getCarStatus()
    {
        return carStatus;
    }


    public void setCarStatus(CarStatus carStatus)
    {
        this.carStatus = carStatus;
    }
    
    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        str.append("[ID = ");
        str.append(id);
        str.append(", Name = ");
        str.append(name);
        str.append(", License Plate = ");
        str.append(licensePlate);

        str.append(", Car Status = ");
        str.append(carStatus);

        
        str.append(" ]");
        return str.toString();
    }
}