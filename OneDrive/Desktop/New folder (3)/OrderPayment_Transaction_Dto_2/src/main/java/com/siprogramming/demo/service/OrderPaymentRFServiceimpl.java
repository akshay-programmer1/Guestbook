package com.siprogramming.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.siprogramming.demo.ORPF_ExceptionService;
import com.siprogramming.demo.dto.OrderPaymentRatingFeedback_Dto;
import com.siprogramming.demo.entity.Feedback;
import com.siprogramming.demo.entity.Order;
import com.siprogramming.demo.entity.Payment;
import com.siprogramming.demo.entity.Rating;
import com.siprogramming.demo.repository.FeedbackRepo;
import com.siprogramming.demo.repository.OrderRepo;
import com.siprogramming.demo.repository.PaymentRepo;
import com.siprogramming.demo.repository.RatingRepo;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class OrderPaymentRFServiceimpl implements OrderPaymentRF_Service {

	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	PaymentRepo paymentRepo;
	
	@Autowired
	RatingRepo ratingRepo;
	
	@Autowired
	FeedbackRepo feedbackRepo;
	
	
	@Override
	@Transactional(value = TxType.SUPPORTS)
	public void makeOrder(OrderPaymentRatingFeedback_Dto dto) {
		
		
		saveOrder(dto);
		
		savePayment(dto);
		
		try {
			System.out.println(10/0);
			saveRating(dto);
		
			saveFeedback(dto);
		} catch (ORPF_ExceptionService e) {
			throw new ORPF_ExceptionService("Bhava Bagh..", HttpStatus.BAD_GATEWAY);
		}catch (Exception e) {
			throw new ORPF_ExceptionService("child eception",HttpStatus.BAD_REQUEST);
		}
	
			
		
	}

	@Transactional
	private void saveFeedback(OrderPaymentRatingFeedback_Dto dto) {
		Feedback feedback=new Feedback();
		feedback.setfName(dto.getfName());
		feedback.setfMessage(dto.getfMessage());
		feedbackRepo.save(feedback);
	}

	@Transactional
	private void saveRating(OrderPaymentRatingFeedback_Dto dto) {
		Rating rating =new Rating();
		rating.setrRating(dto.getrRating());
		rating.setrComment(dto.getrComment());
		ratingRepo.save(rating);
	}


	private void savePayment(OrderPaymentRatingFeedback_Dto dto) {
		Payment payment=new Payment();
		payment.setpAmount(dto.getpAmount());
		payment.setpTime(dto.getpTime());
		paymentRepo.save(payment);
	}


	private void saveOrder(OrderPaymentRatingFeedback_Dto dto) {
		Order ord=new Order();
		ord.setoType(dto.getoType());
		ord.setoLocation(dto.getoLocation());
		orderRepo.save(ord);
	}

}
