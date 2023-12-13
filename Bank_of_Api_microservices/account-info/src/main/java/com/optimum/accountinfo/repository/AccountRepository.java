package com.optimum.accountinfo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.optimum.accountinfo.account.Account;



public interface AccountRepository extends MongoRepository<Account, Integer> {

    Account findByAccountId(int accountId);

    Account findByAccountType(String accountType);

	Account findByUserId(int userId);

	Account save(Account account);

	List<Account> findAll();




	
}