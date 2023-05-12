package com.Project.Application.managerintern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class utility {
    @Autowired
    private ManagerRepo managerRepo;

    @Autowired
    private InternRepo internRepo;



}
