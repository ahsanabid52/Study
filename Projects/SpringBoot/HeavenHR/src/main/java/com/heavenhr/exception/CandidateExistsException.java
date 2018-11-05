package com.heavenhr.exception;

public class CandidateExistsException extends RuntimeException
{
    static final long serialVersionUID = -3387516993334229948L;
    
    public CandidateExistsException(String message)
    {
        super(message);
    }
}