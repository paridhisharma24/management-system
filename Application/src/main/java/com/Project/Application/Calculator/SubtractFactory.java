package com.Project.Application.Calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubtractFactory implements OperationFactory{

    @Autowired
    Subtract subtract;
    public SubtractFactory(){
    }
    public Subtract getObj(){
        return subtract;
    }
}
