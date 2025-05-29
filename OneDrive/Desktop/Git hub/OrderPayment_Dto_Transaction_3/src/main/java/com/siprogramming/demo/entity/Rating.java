package com.siprogramming.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Rating3")
public class Rating {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int rId;
	private String rRating;
	
	
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public String getrRating() {
		return rRating;
	}
	public void setrRating(String rRating) {
		this.rRating = rRating;
	}

}
