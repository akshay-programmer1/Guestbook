package com.siprogramming.demo.dto;

import java.util.Date;

public class OrderPayRF_Dto {
	
	private String oName;
	private String oType;
	
	private String pType;
	private Date pTime;
	
	private String rRating;
	
	private String fName;
	private String fDescription;
	
	
	public String getoName() {
		return oName;
	}
	public void setoName(String oName) {
		this.oName = oName;
	}
	public String getoType() {
		return oType;
	}
	public void setoType(String oType) {
		this.oType = oType;
	}
	public String getpType() {
		return pType;
	}
	public void setpType(String pType) {
		this.pType = pType;
	}
	public Date getpTime() {
		return pTime;
	}
	public void setpTime(Date pTime) {
		this.pTime = pTime;
	}
	public String getrRating() {
		return rRating;
	}
	public void setrRating(String rRating) {
		this.rRating = rRating;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getfDescription() {
		return fDescription;
	}
	public void setfDescription(String oDescription) {
		this.fDescription = oDescription;
	}

}
