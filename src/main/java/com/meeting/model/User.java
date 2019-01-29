package com.meeting.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.LastModifiedDate;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@ApiModelProperty(hidden=true)
	private int id;
	
	private String name;
	
	private String email;

	private String role;
	
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	
	@Temporal(TemporalType.DATE)
	@LastModifiedDate
	private Date modifiedAt;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	
	
}
