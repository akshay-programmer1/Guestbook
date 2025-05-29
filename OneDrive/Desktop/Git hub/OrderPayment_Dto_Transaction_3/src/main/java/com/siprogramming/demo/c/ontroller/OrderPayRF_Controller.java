package com.siprogramming.demo.c.ontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.siprogramming.demo.dto.OrderPayRF_Dto;
import com.siprogramming.demo.service.OrderPayRF_Service;

@RestController
public class OrderPayRF_Controller {
	
	@Autowired
	OrderPayRF_Service orderPayRF_Service;

	@PostMapping("order")
	public String beginOrder(@RequestBody OrderPayRF_Dto dto) {
		
		orderPayRF_Service.makeOrder(dto);
		return "Sucessful..";
	}
}
