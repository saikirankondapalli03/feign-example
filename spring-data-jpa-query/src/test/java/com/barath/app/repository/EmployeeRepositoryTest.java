package com.barath.app.repository;

import com.barath.app.runner.SpringJPARunner;
import com.barath.app.test.configuration.Employee;
import com.barath.app.test.configuration.EmployeeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class EmployeeRepositoryTest extends SpringJPARunner {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testSaveEmployee() {
        Employee employee =  this.employeeRepository.save(new Employee("BARATH",25, Employee.EmployeeGender.MALE));
        Assert.assertEquals("BARATH",employee.getEmployeeName());
        Assert.assertEquals(Employee.EmployeeGender.MALE,employee.getEmployeeGender());
        Assert.assertEquals(25,employee.getEmployeeAge());
    }

    @Test
    public void testFindCustomEmployeesLessThanAge() throws Exception{

        int employeeAge = 50;
        this.employeeRepository.save(new Employee("BARATH",25, Employee.EmployeeGender.MALE));
        this.employeeRepository.save(new Employee("BARRY",52, Employee.EmployeeGender.MALE));
        List<Employee> employees = this.employeeRepository.findCustomEmployeesLessThanAge(employeeAge);
        logger.info("employees {}",mapper.writeValueAsString(employees));
        Assert.assertEquals(2, this.employeeRepository.findAll().size());
    }
}
