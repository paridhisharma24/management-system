package com.Project.Application.Calculator;

import org.springframework.stereotype.Component;

@Component
public interface OperationFactory {
    public OpnImplementation getObj();
}
