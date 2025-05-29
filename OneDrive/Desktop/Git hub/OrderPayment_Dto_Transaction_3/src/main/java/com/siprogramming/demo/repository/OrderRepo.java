package com.siprogramming.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siprogramming.demo.entity.Order;
@Repository
public interface OrderRepo extends JpaRepository<Order, Integer>{

}
