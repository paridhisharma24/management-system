package com.Project.Application.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundEx extends RuntimeException{
    public UserNotFoundEx(String message, int id){
        super(message);
    }
}
