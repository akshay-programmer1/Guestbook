package com.siprogramming.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siprogramming.demo.entity.Feedback;


public interface FeedbackRepo extends JpaRepository<Feedback, Integer>{

}
