package com.barath.app.test.configuration;

import java.util.List;

public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public Employee saveEmployee(Employee employee) {

        return this.employeeRepository.save(employee);
    }

    public List<Employee> saveEmployees(List<Employee> employees) {

        return this.employeeRepository.saveAll(employees);
    }

    public Employee getEmployee(Long employeeId) {

        return this.employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException("emp not found "));
    }


    public List<Employee> findAll() {

        return this.employeeRepository.findAll();
    }



}
