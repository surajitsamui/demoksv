package org.example.demoksv.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class EmployeeServiceImplV2 implements EmployeeService{
    @Override
    public void employeeSave() {
        System.out.println("this is second employee method to save employee");
    }
}
