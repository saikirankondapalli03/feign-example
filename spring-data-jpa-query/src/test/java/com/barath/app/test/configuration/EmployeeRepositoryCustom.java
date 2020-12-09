package com.barath.app.test.configuration;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepositoryCustom {

    @Query(value = "select * from employee e where e.emp_age < ?1",nativeQuery = true)
    List<Employee> findCustomEmployeesLessThanAge(int age);
}
