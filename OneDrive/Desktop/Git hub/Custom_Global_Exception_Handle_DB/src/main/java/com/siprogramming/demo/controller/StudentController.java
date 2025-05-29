package com.siprogramming.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.siprogramming.demo.customexception.StudentServiceException;
import com.siprogramming.demo.entity.Student;
import com.siprogramming.demo.service.StudentServicee;

@RestController
public class StudentController {
	
	@Autowired
	StudentServicee studentServicee;

	@PostMapping("student")
	public String saveStudent(@RequestBody Student student) {
		
		studentServicee.saveStud(student);
		return "Data Added";
		
	}
		
//		try {
//			studentServicee.saveStud(student);
//		} catch (StudentServiceException p) {
//		return new	ResponseEntity(p.getMessage(),p.getHttpStatus());
//		}
//		catch (Exception e) {
//			return new	ResponseEntity("Controller exception",HttpStatus.BAD_REQUEST);
//		}
//	
//		
//		return null;
//		
//	}
}
