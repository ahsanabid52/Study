package com.mytaxi.datatransferobject;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainvalue.GeoCoordinate;
import com.mytaxi.domainvalue.OnlineStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DriverDTO
{
    @JsonIgnore
    private Long id;

    @NotNull(message = "Username can not be null!")
    private String username;

    @NotNull(message = "Password can not be null!")
    private String password;

    private GeoCoordinate coordinate;
    private Boolean deleted;
    private OnlineStatus onlineStatus;
    private CarDO carSelectedId;


    private DriverDTO()
    {}


    private DriverDTO(
        Long id, String username, String password, GeoCoordinate coordinate, Boolean deleted,
        OnlineStatus onlineStatus, CarDO carSelectedId)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.coordinate = coordinate;
        this.deleted = deleted;
        this.onlineStatus = onlineStatus;
        this.carSelectedId = carSelectedId;
    }


    public static DriverDTOBuilder newBuilder()
    {
        return new DriverDTOBuilder();
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


    public String getUsername()
    {
        return username;
    }


    public String getPassword()
    {
        return password;
    }


    public GeoCoordinate getCoordinate()
    {
        return coordinate;
    }


    public Boolean getDeleted()
    {
        return deleted;
    }


    public OnlineStatus getOnlineStatus()
    {
        return onlineStatus;
    }


    public void setDeleted(Boolean deleted)
    {
        this.deleted = deleted;
    }


    public void setCoordinate(GeoCoordinate coordinate)
    {
        this.coordinate = coordinate;
    }


    public void setOnlineStatus(OnlineStatus onlineStatus)
    {
        this.onlineStatus = onlineStatus;
    }


    public void setUsername(String username)
    {
        this.username = username;
    }


    public void setPassword(String password)
    {
        this.password = password;
    }


    public CarDO getCarSelectedId()
    {
        return carSelectedId;
    }


    public void setCarSelectedId(CarDO carSelectedId)
    {
        this.carSelectedId = carSelectedId;
    }

    public static class DriverDTOBuilder
    {
        private Long id;
        private String username;
        private String password;
        private GeoCoordinate coordinate;
        private Boolean deleted;
        private OnlineStatus onlineStatus;
        private CarDO carSelectedId;


        public DriverDTOBuilder setId(Long id)
        {
            this.id = id;
            return this;
        }


        public DriverDTOBuilder setUsername(String username)
        {
            this.username = username;
            return this;
        }


        public DriverDTOBuilder setPassword(String password)
        {
            this.password = password;
            return this;
        }


        public DriverDTOBuilder setCoordinate(GeoCoordinate coordinate)
        {
            this.coordinate = coordinate;
            return this;
        }


        public DriverDTOBuilder setDeleted(Boolean deleted)
        {
            this.deleted = deleted;
            return this;
        }


        public DriverDTOBuilder setOnlineStatus(OnlineStatus onlineStatus)
        {
            this.onlineStatus = onlineStatus;
            return this;
        }


        public DriverDTOBuilder setCarSelectedId(CarDO carSelectedId)
        {
            this.carSelectedId = carSelectedId;
            return this;
        }


        public DriverDTO createDriverDTO()
        {
            return new DriverDTO(id, username, password, coordinate, deleted, onlineStatus, carSelectedId);
        }
    }
}