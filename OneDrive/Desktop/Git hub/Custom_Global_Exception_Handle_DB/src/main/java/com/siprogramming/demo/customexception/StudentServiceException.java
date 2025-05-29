package com.siprogramming.demo.customexception;

import org.springframework.http.HttpStatus;

public class StudentServiceException  extends RuntimeException{

	
	public String message;
	public HttpStatus httpStatus;
	
	
	public StudentServiceException(String message, HttpStatus httpStatus) {
		
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
