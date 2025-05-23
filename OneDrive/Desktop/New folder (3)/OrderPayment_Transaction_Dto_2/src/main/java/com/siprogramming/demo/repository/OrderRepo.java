package com.siprogramming.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siprogramming.demo.entity.Order;


public interface OrderRepo extends JpaRepository<Order, Integer> {

}
