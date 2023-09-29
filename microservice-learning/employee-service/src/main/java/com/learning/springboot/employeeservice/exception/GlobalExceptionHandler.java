package com.learning.springboot.employeeservice.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Error> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		Error error = new Error(1001, "Data Not Found", ex.getLocalizedMessage());
		return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DataAlreadyExistException.class)
	public ResponseEntity<Error> handleDataAlreadyExistException(DataAlreadyExistException ex, WebRequest request) {
		Error error = new Error(1002, "Data Already Exist", ex.getMessage());
		return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest rquest) {

		List<Error> responseErrorList = new ArrayList<>();
		List<FieldError> validationErrorList = ex.getBindingResult().getFieldErrors();
		validationErrorList.forEach((error) -> {
			Error apiError = new Error(1003, "Invalid Input Data", error.getDefaultMessage());
			responseErrorList.add(apiError);
		});
		return new ResponseEntity<>(responseErrorList, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Error> handleGlobalException(Exception ex, WebRequest request) {
		Error error = new Error(1004, "Internal Server Error", ex.getMessage());
		return new ResponseEntity<Error>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
