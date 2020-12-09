package com.barath.app;

import com.barath.app.runner.SpringWebRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;


@AutoConfigureMockMvc
public class ApplicationTests extends SpringWebRunner {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testApplicationStartup() {

		Assert.notNull(mockMvc, "mock mvc cannot be null");
	}

}
