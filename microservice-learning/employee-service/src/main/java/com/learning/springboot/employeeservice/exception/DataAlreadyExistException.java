package com.learning.springboot.employeeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DataAlreadyExistException extends RuntimeException {

	private String errorMessage;

	public DataAlreadyExistException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
}
