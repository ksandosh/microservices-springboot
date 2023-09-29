package com.learning.springboot.employeeservice;

//import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

//import org.h2.tools.Server;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class EmployeeServiceApplication {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	@LoadBalanced
	public WebClient.Builder webClient() {
		return WebClient.builder();
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

	// Code to use same H2 database for different Spring Boot Applications

	/*
	 * @Bean(initMethod = "start", destroyMethod = "stop") public Server
	 * inMemoryH2DatabaseServer() throws SQLException { return
	 * Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9090"); }
	 */

}
