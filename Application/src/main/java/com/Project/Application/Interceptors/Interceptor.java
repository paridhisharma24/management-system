package com.Project.Application.Interceptors;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class Interceptor {
    @Autowired
    HttpServletRequest request;

    @Before("execution(* com.Project.Application.*.*(..))")
    public void getHeader(){
        System.out.println("Aspect executed");
        String val = request.getHeader("token");
        if(val.equals("*")){
            System.out.println("Validated");
        }
        else
            System.out.println("Can't Validate");
    }
}
