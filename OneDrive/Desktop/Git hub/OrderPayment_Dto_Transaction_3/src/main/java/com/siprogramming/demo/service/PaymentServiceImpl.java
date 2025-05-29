package com.siprogramming.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import com.siprogramming.demo.entity.Payment;
import com.siprogramming.demo.repository.PaymentRepo;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Component
public class PaymentServiceImpl  {

	@Autowired
	PaymentRepo paymentRepo;

	@Transactional(value = TxType.REQUIRES_NEW)
	public void makeOrder(Payment payment) {
	
		paymentRepo.save(payment);

	}
}
