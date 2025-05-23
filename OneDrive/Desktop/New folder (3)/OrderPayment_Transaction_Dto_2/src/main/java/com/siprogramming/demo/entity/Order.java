package com.siprogramming.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Order_Transaction")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int oId;
	private String oType;
	private String oLocation;
	
	public int getoId() {
		return oId;
	}
	public void setoId(int oId) {
		this.oId = oId;
	}
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
	
	
	
	
	
}
