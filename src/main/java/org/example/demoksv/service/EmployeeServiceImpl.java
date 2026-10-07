package org.example.demoksv.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
//@Primary
public class EmployeeServiceImpl implements EmployeeService{

    @Override
    public void employeeSave() {
        System.out.println("added new employee");
    }
}
