package com.Project.Application.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetOperation {
    OperationFactory op;

    @Autowired
    AddFactory addFactory;
    @Autowired
    SubtractFactory subtractFactory;
    @Autowired
    MultiplyFactory multiplyFactory;
    @Autowired
    DivideFactory divideFactory;

    public GetOperation(){}
    public GetOperation(String operator) {
        if(operator.equals("Add")){
            op = addFactory;
        }
        else if(operator.equals("Subtract")){
            op = subtractFactory;
        }
        else if(operator.equals("Multiply")){
            op = multiplyFactory;
        }
        else if(operator.equals("Divide")){
            op = divideFactory;
        }
    }


    public int getResult(List<Integer> numbers){
        OpnImplementation res = op.getObj();
        return res.evaluate(numbers);
    }
}
