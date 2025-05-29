package com.siprogramming.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.siprogramming.demo.entity.Order;
import com.siprogramming.demo.repository.OrderRepo;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;


@Service
public class OrderServiceImpl  {

	@Autowired
	private OrderRepo orderRepo;

	@Transactional(value = TxType.REQUIRES_NEW)
	public void orderFood(Order order) {
		
		orderRepo.save(order);
	}


}
