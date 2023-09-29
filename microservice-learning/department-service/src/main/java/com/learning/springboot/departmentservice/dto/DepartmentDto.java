package com.learning.springboot.departmentservice.dto;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
	private Long id;

	@NotEmpty(message = "Department Name cannot be Empty!")
	private String departmentName;

	@NotEmpty(message = "Department Description cannot be Empty!")
	private String departmentDescription;

	@NotEmpty(message = "Department Code cannot be Empty!")
	private String departmentCode;
}
