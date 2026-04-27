package com.employee.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends RuntimeException{

	public String message;
	public HttpStatus status;
	
	public BadRequestException(String message) {
		super();
		this.message = message;
		this.status = HttpStatus.BAD_REQUEST;
	} 

	public String getMessage() {
		return message;
	}

	public HttpStatus getStatus() {
		return status;
	}
}
