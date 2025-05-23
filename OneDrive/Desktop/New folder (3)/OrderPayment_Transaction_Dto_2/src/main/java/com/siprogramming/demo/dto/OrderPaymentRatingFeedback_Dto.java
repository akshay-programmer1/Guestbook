package com.siprogramming.demo.dto;

import java.time.LocalDateTime;

public class OrderPaymentRatingFeedback_Dto {

	private String oType;
	private String oLocation;
	
	private int pAmount;
	private LocalDateTime pTime;
	
	private String rRating;
	private String rComment;
	
	private String fName;
	private String fMessage;
	
	
	
	
	public String getoType() {
		return oType;
	}
	public void setoType(String oType) {
		this.oType = oType;
	}
	public String getoLocation() {
		return oLocation;
	}
	public void setoLocation(String oLocation) {
		this.oLocation = oLocation;
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
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getfMessage() {
		return fMessage;
	}
	public void setfMessage(String fMessage) {
		this.fMessage = fMessage;
	}
	
	
	
	
	
}
