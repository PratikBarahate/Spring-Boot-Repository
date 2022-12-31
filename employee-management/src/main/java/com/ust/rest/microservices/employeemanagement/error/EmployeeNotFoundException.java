package com.ust.rest.microservices.employeemanagement.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException(String message) {
		super(message);
	}
}
