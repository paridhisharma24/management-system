package com.Project.Application.Calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MultiplyFactory implements OperationFactory{
    @Autowired
    Multiply multiply;
    public MultiplyFactory(){
    }
    public Multiply getObj(){
        return multiply;
    }
}
