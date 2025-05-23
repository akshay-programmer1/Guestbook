package com.siprogramming.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siprogramming.demo.entity.Payment;


public interface PaymentRepo extends JpaRepository<Payment, Integer> {

}
