package com.siprogramming.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.siprogramming.demo.dto.OrderPayRF_Dto;

import com.siprogramming.demo.entity.Rating;

import com.siprogramming.demo.repository.RatingRepo;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Component
public class RatingServiceImpl  {

	@Autowired
	RatingRepo ratingRepo;

	
	public void makeOrder(Rating rating) {
	
		ratingRepo.save(rating);

	}
}
