package com.siprogramming.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Rating_Transaction")
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String rRating;
	private String rComment;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getrRating() {
		return rRating;
	}
	public void setrRating(String rRating) {
		this.rRating = rRating;
	}
	public String getrComment() {
		return rComment;
	}
	public void setrComment(String rComment) {
		this.rComment = rComment;
	}
	
	
	
	
	
}
