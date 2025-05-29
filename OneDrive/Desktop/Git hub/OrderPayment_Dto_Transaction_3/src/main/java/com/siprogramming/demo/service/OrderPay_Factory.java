package com.siprogramming.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.siprogramming.demo.dto.OrderPayRF_Dto;
import com.siprogramming.demo.entity.Feedback;
import com.siprogramming.demo.entity.Order;
import com.siprogramming.demo.entity.Payment;
import com.siprogramming.demo.entity.Rating;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
@Primary
public class OrderPay_Factory implements OrderPayRF_Service{

	@Autowired
	private OrderServiceImpl orderServiceImpl;

	@Autowired
	private PaymentServiceImpl paymentServiceImpl;
	
	@Autowired
	RatingServiceImpl ratingServiceImpl;
	
	@Autowired
	FeedbackServiceImpl feedbackServiceImpl;
	
	@Transactional
	public void makeOrder(OrderPayRF_Dto dto) {
		
		
		Order order=new Order();
		order.setoName(dto.getoName());
		order.setoType(dto.getoType());
		orderServiceImpl.orderFood(order);
		

		Payment payment=new Payment();
		payment.setpType(dto.getpType());
		payment.setpTime(dto.getpTime());
		paymentServiceImpl.makeOrder(payment);

		
		Rating rating=new Rating();
		rating.setrRating(dto.getrRating());
		ratingServiceImpl.makeOrder(rating);
		
		System.out.println(10/0);
		
		Feedback feedback=new Feedback();
		feedback.setfDescription(dto.getfDescription());
		feedback.setfName(dto.getfName());
		feedbackServiceImpl.makeOrder(feedback);
	}
}
