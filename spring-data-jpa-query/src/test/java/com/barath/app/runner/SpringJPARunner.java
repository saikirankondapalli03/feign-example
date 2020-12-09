package com.barath.app.runner;

import com.barath.app.test.configuration.Employee;
import com.barath.app.test.configuration.EmployeeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@DataJpaTest
@EnableJpaRepositories(basePackageClasses = Employee.class)
public class SpringJPARunner extends SpringWebRunner{


}
