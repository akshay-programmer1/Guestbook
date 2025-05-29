package com.siprogramming.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.siprogramming.demo.dto.OrderPayRF_Dto;
import com.siprogramming.demo.entity.Feedback;
import com.siprogramming.demo.repository.FeedbackRepo;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Component
public class FeedbackServiceImpl {

	@Autowired
	FeedbackRepo feedbackRepo;

	//@Transactional(value = TxType.REQUIRES_NEW)
	public void makeOrder(Feedback feedback) {
		feedbackRepo.save(feedback);
	}
}
