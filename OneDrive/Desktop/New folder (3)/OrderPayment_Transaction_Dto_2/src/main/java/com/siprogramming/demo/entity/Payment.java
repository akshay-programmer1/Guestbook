package com.siprogramming.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Payment_Transaction")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int pId;
	private int pAmount;
	private LocalDateTime pTime;
	
	
	
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int getpAmount() {
		return pAmount;
	}
	public void setpAmount(int pAmount) {
		this.pAmount = pAmount;
	}
	public LocalDateTime getpTime() {
		return pTime;
	}
	public void setpTime(LocalDateTime pTime) {
		this.pTime = pTime;
	}
	
	
	
}
