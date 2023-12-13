package com.example.userdetails.BankUserDetails.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	public User() {
	}	

	public User(Integer userId, String userName, String userPassword, String address) {
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.address = address;
	}
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="User_Id")
	private Integer userId;
	
	@Column(name="User_Name")
	private String userName;
	
	@Column(name="User_Password")
	private String userPassword;
	
	@Column(name="User_Address")
	private String address;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
