package com.learning.springboot.departmentservice.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.springboot.departmentservice.dto.DepartmentDto;
import com.learning.springboot.departmentservice.entity.Department;
import com.learning.springboot.departmentservice.exception.ResourceNotFoundException;
import com.learning.springboot.departmentservice.repository.DepartmentRepository;
import com.learning.springboot.departmentservice.service.DepartmentService;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository departmentRepository;

	private ObjectMapper mapper;

	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

		// Convert Department DTO to Department JPA Entity
		Department department = mapper.convertValue(departmentDto, Department.class);

		Department savedDepartment = departmentRepository.save(department);
		
		// Convert Department JAP Entity to Department DTO
		departmentDto = mapper.convertValue(savedDepartment, DepartmentDto.class);

		return departmentDto;
	}

	@Override
	public DepartmentDto getDepartmentByCode(String departmentCode) {

		Department foundDepartment = departmentRepository.findByDepartmentCode(departmentCode);
		
		if(null == foundDepartment) {
			throw new ResourceNotFoundException("Department", "departmentCode", departmentCode);
		}
		
		// Convert Department JAP Entity to Department DTO
		DepartmentDto departmentDto = mapper.convertValue(foundDepartment, DepartmentDto.class);
		
		return departmentDto;
	}
}
