package com.learning.springboot.employeeservice.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    
	private Long id;
    
    @NotEmpty(message = "First Name cannot be empty!")
    private String firstName;
    
    @NotEmpty(message = "Last Name cannot be empty!")
    private String lastName;
    
    @NotEmpty(message = "E-mail cannot be empty!")
    @Email(message = "E-mail address provided is not valid!")
    private String email;
    
    @NotEmpty(message = "Department Code cannot be empty!")
    private String departmentCode;
}
