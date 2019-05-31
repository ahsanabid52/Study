package com.heavenhr.exception;

public class ConstraintsViolationException extends RuntimeException
{

    static final long serialVersionUID = -3387516993224229948L;


    public ConstraintsViolationException(String message)
    {
        super(message);
    }

}
