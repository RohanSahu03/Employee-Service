package com.employee.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends RuntimeException {

	public String message;
	public HttpStatus status;
	
	public ResourceNotFoundException(String message) {
		super();
		this.message = message;
		this.status = HttpStatus.NOT_FOUND;
	} 

	public String getMessage() {
		return message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	
	
}
