package com.learning.springboot.departmentservice;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@EnableEurekaClient
public class DepartmentServiceApplication {

	//@Autowired
	//private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

	/*
	 * @PostConstruct private void initDb() { String sqlStatments[] = {
	 * "insert into departments(departmentName, departmentDesc, departmentCode) values('IT', 'Information Technology', 'IT001')"
	 * ,
	 * "insert into departments(departmentName, departmentDesc, departmentCode) values('CSC', 'Computer Science', 'CSC001')"
	 * };
	 * 
	 * Arrays.asList(sqlStatments).forEach(sql -> { jdbcTemplate.execute(sql); });
	 * 
	 * }
	 */

}
