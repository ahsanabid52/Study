package com.mytaxi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Car is already in use by some other driver.")
public class CarNotInUseException extends Exception
{
    static final long serialVersionUID = -3387516993334229948L;


    public CarNotInUseException(String message)
    {
        super(message);
    }

}
