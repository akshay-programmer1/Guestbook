package com.siprogramming.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siprogramming.demo.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
