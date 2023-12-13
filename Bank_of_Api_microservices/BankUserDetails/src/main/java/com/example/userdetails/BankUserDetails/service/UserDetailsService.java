package com.example.userdetails.BankUserDetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userdetails.BankUserDetails.entity.User;
import com.example.userdetails.BankUserDetails.repository.UserDetailsRepository;
@Service
public class UserDetailsService implements UserDetails{
	
	@Autowired
	UserDetailsRepository userDetailsRepository;
    @Override
	public User createUserDetails( User user) {
		// TODO Auto-generated method stub
		return userDetailsRepository.save(user);
	}

	public User editUserDetails(User user) {
		// TODO Auto-generated method stub
		return userDetailsRepository.save(user);
	}
   @Override
	public boolean validateUser( Integer userId,String userPassword) {
    User obj=userDetailsRepository.findByUserIdAndUserPassword(userId,userPassword);
		System.out.println("User obj ::: "+obj);
		if(obj==null)
			return false;
		else
			return true;
	}



public Iterable<User> getUserDetails() {
	// TODO Auto-generated method stub
	return userDetailsRepository.findAll();
}

public User getloginuser(int userid) {
	// TODO Auto-generated method stub
	return userDetailsRepository.findByUserId(userid);
}
		

}
