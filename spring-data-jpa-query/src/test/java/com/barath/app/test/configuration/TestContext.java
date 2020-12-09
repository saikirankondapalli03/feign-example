package com.barath.app.test.configuration;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;

@TestConfiguration
public class TestContext {


    @Bean
    public EmployeeService employeeService(EmployeeRepository employeeRepository){
        return new EmployeeService(employeeRepository);
    }



}

