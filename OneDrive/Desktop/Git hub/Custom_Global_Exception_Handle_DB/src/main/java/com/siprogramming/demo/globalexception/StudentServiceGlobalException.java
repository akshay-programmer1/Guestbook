package com.siprogramming.demo.globalexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.siprogramming.demo.customexception.StudentServiceException;

@ControllerAdvice
public class StudentServiceGlobalException {

	@ExceptionHandler
	public ResponseEntity globalExceptionHandling(StudentServiceException stu) {
		
		return new ResponseEntity(stu.getMessage(),stu.getHttpStatus());
		
	}
	
	@ExceptionHandler
	public ResponseEntity globalExceptionHandling(Exception e) {
		
		return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		
	}
}
