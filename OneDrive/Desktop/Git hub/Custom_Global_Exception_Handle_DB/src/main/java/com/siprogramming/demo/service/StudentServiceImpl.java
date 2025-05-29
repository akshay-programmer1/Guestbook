package com.siprogramming.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.siprogramming.demo.customexception.StudentServiceException;
import com.siprogramming.demo.entity.Student;
import com.siprogramming.demo.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentServicee {

	@Autowired
	StudentRepo studentRepo;
	
	@Override
	public void saveStud(Student stud) {
		
		
		
		try {
			
			
			
			studentRepo.save(stud);
			
		}
		
		
		catch (Exception e) {
			throw new StudentServiceException("problame in db", HttpStatus.BAD_GATEWAY);
		}
	
		
	}

	@Override
	public void updateStud(int id, Student std) {
		studentRepo.findById(id).get();
		
		
		
	}

	@Override
	public Student getStud(int id) {
		
		
		
		return studentRepo.findById(id).get();
	}

	@Override
	public void delStudent(int id) {
		studentRepo.deleteById(id);
		
	}

}
