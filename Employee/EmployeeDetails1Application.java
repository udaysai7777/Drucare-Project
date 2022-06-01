package com.Employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
@Configuration
@SpringBootApplication
@PropertySource("classpath:application.properties")
public class EmployeeDetails1Application {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeDetails1Application.class, args);
	}

}
