package com.learning.springboot.employeeservice.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.springboot.employeeservice.dto.APIResponseDto;
import com.learning.springboot.employeeservice.dto.DepartmentDto;
import com.learning.springboot.employeeservice.dto.EmployeeDto;
import com.learning.springboot.employeeservice.entity.Employee;
import com.learning.springboot.employeeservice.exception.ResourceNotFoundException;
import com.learning.springboot.employeeservice.repository.EmployeeRepository;
import com.learning.springboot.employeeservice.service.APIClient;
import com.learning.springboot.employeeservice.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ObjectMapper mapper;

	// private WebClient webClient;

	@Autowired
	private WebClient.Builder weClientBuilder;

	@Autowired
	private APIClient apiClient;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

		// Convert DTO to Entity
		Employee employee = mapper.convertValue(employeeDto, Employee.class);

		Employee saveDEmployee = employeeRepository.save(employee);

		// Convert Entity to DTO
		EmployeeDto savedEmployeeDto = mapper.convertValue(saveDEmployee, EmployeeDto.class);

		return savedEmployeeDto;
	}

	@Override
	public APIResponseDto getEmployeeById(Long employeeId) {

		Employee retrievedEmployee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId.toString()));

		String departmentCode = retrievedEmployee.getDepartmentCode();

		// Invoke using ResponseEntity
		/*
		 * ResponseEntity<DepartmentDto> responseEntity =
		 * restTemplate.getForEntity("http://DEPARTMENT-SERVICE/api/departments/" +
		 * employee.getDepartmentCode(), DepartmentDto.class); DepartmentDto
		 * departmentDto = responseEntity.getBody();
		 */

		// Invoke using Web Client
		/*
		 * DepartmentDto departmentDto = webClient.get()
		 * .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
		 * .retrieve() .block();
		 */

		// Invoke using Spring Feign Client
		// DepartmentDto departmentDto = apiClient.getDepartment(departmentCode);

		// Invoke using Web Client - Load balanced
		DepartmentDto departmentDto = weClientBuilder.build().get()
				.uri("http://DEPARTMENT-SERVICE/api/departments/{departmentCode}", departmentCode)
				// .body(requestBody, DepartmentRequestBody.class)
				.retrieve().bodyToMono(DepartmentDto.class).block();

		EmployeeDto employeeDto = mapper.convertValue(retrievedEmployee, EmployeeDto.class);

		APIResponseDto apiResponseDto = new APIResponseDto();
		apiResponseDto.setEmployee(employeeDto);
		apiResponseDto.setDepartment(departmentDto);

		return apiResponseDto;
	}
}
