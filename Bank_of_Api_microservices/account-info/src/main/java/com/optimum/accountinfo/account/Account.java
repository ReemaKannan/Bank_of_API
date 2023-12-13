package com.optimum.accountinfo.account;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "accountdata")

public class Account {
	@Id
	private int accountId;
	private String accountType;
	private int accountBalance;
	private String secretePassword;
	private int userId;

	public Account() {

	}

	public Account(int accountId, String accountType, int accountBalance, String secretePassword, int userId) {
		this.accountId = accountId;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.secretePassword = secretePassword;
		this.userId = userId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getSecretePassword() {
		return secretePassword;
	}

	public void setSecretePassword(String secretePassword) {
		this.secretePassword = secretePassword;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	
}