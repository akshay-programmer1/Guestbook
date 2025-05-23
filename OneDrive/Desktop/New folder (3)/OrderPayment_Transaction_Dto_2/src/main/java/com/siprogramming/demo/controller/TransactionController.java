package com.siprogramming.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.siprogramming.demo.ORPF_ExceptionService;
import com.siprogramming.demo.dto.OrderPaymentRatingFeedback_Dto;
import com.siprogramming.demo.service.OrderPaymentRF_Service;

@RestController
public class TransactionController {
	@Autowired
	OrderPaymentRF_Service orderPaymentRF_Service;
	
	@PostMapping("order")
	public ResponseEntity Order(@RequestBody OrderPaymentRatingFeedback_Dto dto) {
		try {
			orderPaymentRF_Service.makeOrder(dto);
		}catch (ORPF_ExceptionService e) {
			return new ResponseEntity(e.getMessage(), e.getHttpStatus());
		}catch (Exception e) {
			return new ResponseEntity("Controller eception", HttpStatus.BAD_REQUEST);
		}
		
		return null;
		
	}
}
