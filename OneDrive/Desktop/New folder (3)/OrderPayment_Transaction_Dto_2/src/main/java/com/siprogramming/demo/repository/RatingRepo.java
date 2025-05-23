package com.siprogramming.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siprogramming.demo.entity.Rating;


public interface RatingRepo extends JpaRepository<Rating, Integer> {

}
