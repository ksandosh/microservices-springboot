package com.learning.springboot.employeeservice.service;

import com.learning.springboot.employeeservice.dto.APIResponseDto;
import com.learning.springboot.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    
	EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}
