package com.heavenhr.controller.advice;

import javax.persistence.EntityNotFoundException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.heavenhr.exception.CandidateExistsException;
import com.heavenhr.exception.ConstraintsViolationException;
import com.heavenhr.exception.InvalidStatusException;
import com.heavenhr.model.ResponseInfo;

@ControllerAdvice
public class ApplicationAdvices
{
    
    @ExceptionHandler(InvalidStatusException.class)
    public ResponseEntity<ResponseInfo> invalidStatusException(InvalidStatusException e)
    {
        ResponseInfo er = new ResponseInfo();
        er.setResponeCode(HttpStatus.BAD_REQUEST.toString());
        er.setResponseDescription(e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
    }

    @ExceptionHandler(CandidateExistsException.class)
    public ResponseEntity<ResponseInfo> candidateExistsException(CandidateExistsException e)
    {
        ResponseInfo er = new ResponseInfo();
        er.setResponeCode(HttpStatus.BAD_REQUEST.toString());
        er.setResponseDescription(e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);

    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ResponseInfo> constraintViolationException(ConstraintsViolationException e)
    {
        ResponseInfo er = new ResponseInfo();
        er.setResponeCode(HttpStatus.CONFLICT.toString());
        er.setResponseDescription(e.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(er);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ResponseInfo> entityNotFoundException(EntityNotFoundException e)
    {
        ResponseInfo er = new ResponseInfo();
        er.setResponeCode(HttpStatus.NOT_FOUND.toString());
        er.setResponseDescription(e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }
}