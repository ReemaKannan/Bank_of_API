package com.optimum.accountinfo.account;

public class AccountDTO {
	private int accountId;
	private String accountType;
	private int accountBalance;
	private String secretePassword;
	private int userId;
	
	

	public AccountDTO() {
		
	}
	
	public AccountDTO(int accountId, String accountType, int accountBalance, String secretePassword, int userId) {
		this.setAccountId(accountId);
		this.setAccountType(accountType);
		this.setAccountBalance(accountBalance);
		this.setSecretePassword(secretePassword);
		this.setUserId(userId);
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getSecretePassword() {
		return secretePassword;
	}

	public void setSecretePassword(String secretePassword) {
		this.secretePassword = secretePassword;
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	
}