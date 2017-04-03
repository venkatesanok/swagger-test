package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.Employee;

@RestController
public class SwaggerController {
	@Value("${prop1:default}") private String prop1;
	@Value("${prop2:default}") private String prop2;

	@RequestMapping(method = RequestMethod.GET, value = "/api/javainuse")
	public String sayHello() {
		return "Swagger Hello World";
	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public Employee firstPage() {

		Employee emp = new Employee();
		emp.setName("emp1");
		emp.setDesignation("manager");
		emp.setEmpId("1");
		emp.setSalary(2000);

		return emp;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/world")
	public String sayHelloWorld() {
		return new StringBuilder()
                .append("Message: ")
                .append(prop1).append(" ")
                .append(prop2).append("!")
                .toString();
	}
}
