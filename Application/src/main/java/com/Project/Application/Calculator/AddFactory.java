package com.Project.Application.Calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddFactory implements OperationFactory{
    @Autowired
    AddNum addNum;
    public AddFactory(){
    }

    public AddNum getObj(){
        return addNum;
    }

}

