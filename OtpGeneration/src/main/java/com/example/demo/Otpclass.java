package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Otpclass {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column
	String otp;
	@Column
	int userid;
	
	public Otpclass() {
		// TODO Auto-generated constructor stub
	}

	public Otpclass(int id, String otp, int userid) {
		super();
		this.id = id;
		this.otp = otp;
		this.userid = userid;
	}

	public Otpclass(String otp, int userid) {
		super();
		this.otp = otp;
		this.userid = userid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	
}
