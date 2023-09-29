package com.learning.springboot.departmentservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.learning.springboot.departmentservice.dto.DepartmentDto;

public interface DepartmentService {
	
	DepartmentDto saveDepartment(DepartmentDto departmentDto);
	DepartmentDto getDepartmentByCode(String code) throws JsonProcessingException;
}
