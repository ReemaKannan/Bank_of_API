package com.optimum.accountinfo.service;

import java.util.List;

import com.optimum.accountinfo.account.Account;



public interface AccountService {

	Account findByAccountType(String accountType);

	Account findByAccountId(int accountId);

	List<Account> findAll();

	Account saveAccount(Account account);

	Account findByUserId(int userId);

	
}