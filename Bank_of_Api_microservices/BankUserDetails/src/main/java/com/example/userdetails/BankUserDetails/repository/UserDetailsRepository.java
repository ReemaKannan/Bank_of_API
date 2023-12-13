package com.example.userdetails.BankUserDetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.userdetails.BankUserDetails.entity.User;


@Repository
public interface UserDetailsRepository extends JpaRepository<User,Integer>{


	public User findByUserId(int userid);
	public User findByUserIdAndUserPassword(Integer userId, String userPassword);


	

}
