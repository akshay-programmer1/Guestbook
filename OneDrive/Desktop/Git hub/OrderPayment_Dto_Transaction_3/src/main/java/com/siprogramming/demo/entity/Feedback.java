package com.siprogramming.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Feedback3")
public class Feedback {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int fId;
	private String fName;
	private String fDescription;
	
	
	public int getfId() {
		return fId;
	}
	public void setfId(int fId) {
		this.fId = fId;
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
