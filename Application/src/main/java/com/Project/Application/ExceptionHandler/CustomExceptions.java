package com.Project.Application.ExceptionHandler;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptions  extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDeets> HandleException(Exception e, WebRequest we){
        ErrorDeets deets = new ErrorDeets(
                e.getMessage(),
                we.getDescription(true)
        );
        return new ResponseEntity<ErrorDeets>(deets, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
//    @ResponseBody
    public ResponseEntity<ErrorDeets> InvalidArgException(ConstraintViolationException e, WebRequest we){
        ErrorDeets deets = new ErrorDeets(
                e.getMessage(),
                we.getDescription(true)
        );
        return new ResponseEntity<ErrorDeets>(deets, HttpStatus.BAD_REQUEST);
    }

}
