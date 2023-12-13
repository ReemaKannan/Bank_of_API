package com.optimum.accountinfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optimum.accountinfo.account.Account;
import com.optimum.accountinfo.repository.AccountRepository;



@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findByAccountId(int accountId) {
        return accountRepository.findByAccountId(accountId);
    }

    @Override
    public Account findByAccountType(String accountType) {
        return accountRepository.findByAccountType(accountType);
    }

	@Override
	public Account findByUserId(int userId) {
		return accountRepository.findByUserId(userId);
	}
	
	@Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

}