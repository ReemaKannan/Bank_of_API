package com.example.userdetails.BankUserDetails.service;

import com.example.userdetails.BankUserDetails.entity.User;

public interface UserDetails {

			User createUserDetails(User user);
			boolean validateUser(Integer userId, String userPassword);

	}



