package com.barath.app.service;

import com.barath.app.test.configuration.Employee;
import com.barath.app.test.configuration.EmployeeRepository;
import com.barath.app.runner.SpringWebRunner;
import com.barath.app.test.configuration.EmployeeService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.List;


public class EmployeeServiceTest extends SpringWebRunner {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @MockBean
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @Before
    public void setup(){

        List<Employee> employees = this.setupEmployees();
        Mockito.when(this.employeeRepository.save(Mockito.any(Employee.class))).thenReturn(employees.stream().findFirst().get());
    }

    @Test
    public void testSaveEmployee() {
        logger.info("test save empployee start");
        Employee employee = this.employeeService.saveEmployee(this.getFirstEmployeeFromList());

        Assert.assertEquals("BARATH",employee.getEmployeeName());
        logger.info("test save empployee end");

    }

    private List<Employee> setupEmployees(){
        Employee employee1 = new Employee("BARATH",25, Employee.EmployeeGender.MALE);
        Employee employee2 = new Employee("SACHIN",42, Employee.EmployeeGender.MALE);
        Employee employee3 = new Employee("DHONI",36, Employee.EmployeeGender.MALE);
        Employee employee4 = new Employee("HARI",28, Employee.EmployeeGender.MALE);
        Employee employee5 = new Employee("HARIHARAN",30, Employee.EmployeeGender.MALE);
        Employee employee6 = new Employee("PARI",25, Employee.EmployeeGender.FEMALE);
        Employee employee7 = new Employee("MEGHNA",18, Employee.EmployeeGender.FEMALE);
        Employee employee8 = new Employee("DIVYA",55, Employee.EmployeeGender.FEMALE);
        Employee employee9 = new Employee("SWATHI",35, Employee.EmployeeGender.FEMALE);
        Employee employee10 = new Employee("SIMRAN",45, Employee.EmployeeGender.FEMALE);

        return Arrays.asList(employee1,employee2,employee3,employee4
                ,employee5,employee6,employee7,employee8,employee9,employee10);
    }

    private Employee getFirstEmployeeFromList() {

        return this.setupEmployees().stream().findFirst().get();
    }

}
