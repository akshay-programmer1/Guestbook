package com.siprogramming.demo.service;

import com.siprogramming.demo.entity.Student;

public interface StudentServicee {

	
	public void saveStud(Student stud);
	public void updateStud(int id, Student std);
	public Student getStud(int id);
	public void delStudent(int id);
}
