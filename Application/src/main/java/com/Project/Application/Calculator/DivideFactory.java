package com.Project.Application.Calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DivideFactory implements OperationFactory{
    @Autowired
    Divide divide;
    public DivideFactory(){}
    public Divide getObj(){
        return divide;
    }


}

