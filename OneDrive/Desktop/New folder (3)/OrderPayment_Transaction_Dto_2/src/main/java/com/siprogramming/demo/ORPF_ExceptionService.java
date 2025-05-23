package com.siprogramming.demo;

import org.springframework.http.HttpStatus;

public class ORPF_ExceptionService extends RuntimeException {

	
	String message;
	HttpStatus httpStatus;
	
	
	
	public ORPF_ExceptionService(String message, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
	}
	
	
	public String getMessage() {
		return message;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
	
	
	
	
}
