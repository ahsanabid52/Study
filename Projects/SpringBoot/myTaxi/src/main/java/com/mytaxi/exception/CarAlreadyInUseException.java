package com.mytaxi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Car is not in the use of the driver so it cannot deselect the car.")
public class CarAlreadyInUseException extends Exception
{
    static final long serialVersionUID = -3387516993334229948L;


    public CarAlreadyInUseException(String message)
    {
        super(message);
    }

}
