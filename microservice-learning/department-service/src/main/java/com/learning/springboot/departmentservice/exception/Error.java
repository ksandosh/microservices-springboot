package com.learning.springboot.departmentservice.exception;

import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Error {

	private int errorCode;
	private String errorMessage;
	private String errorDetail;

}
