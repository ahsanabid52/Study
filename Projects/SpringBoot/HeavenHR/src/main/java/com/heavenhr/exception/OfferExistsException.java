package com.heavenhr.exception;

public class OfferExistsException extends RuntimeException
{
    static final long serialVersionUID = -3387516993334229948L;


    public OfferExistsException(String message)
    {
        super(message);
    }

}
