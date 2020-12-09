package com.barath.app.test.configuration;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, EmployeeRepositoryCustom {

        List<Employee> findByEmployeeGender(Employee.EmployeeGender employeeGender);

        List<Employee> findByEmployeeAgeBetween(int start, int end);


    default List<Employee> findAllFemaleEmployees() {
            return this.findByEmployeeGender(Employee.EmployeeGender.FEMALE);
            }

    default List<Employee> findAllMaleEmployees() {
            return this.findByEmployeeGender(Employee.EmployeeGender.MALE);
            }

    /**
     * custom query demonstration.
     *
     **/
    @Query(name = "SELECT emp from EMPLOYEE e where e.emp_name=?1", nativeQuery = true)
    List<Employee> findByEmployeeName(String empName);


}