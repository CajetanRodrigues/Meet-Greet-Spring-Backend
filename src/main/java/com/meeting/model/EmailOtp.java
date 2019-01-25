package com.meeting.model;

import javax.persistence.Entity;

import javax.persistence.Id;


@Entity
public class EmailOtp {
	// The model properties here and the UI should match.
	@Id
	private String email;
	private String otp;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	
	

}
