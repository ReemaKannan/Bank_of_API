package com.example.userdetails.BankUserDetails.controller;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.userdetails.BankUserDetails.entity.User;
import  com.example.userdetails.BankUserDetails.service.UserDetailsService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@RestController
@CrossOrigin
public class UserDetailsController {
		@Autowired
		UserDetailsService userDetailService;
		
		@PostMapping(value="/registeruser")
		public ResponseEntity<?> createUserDetails(@RequestBody User user)
		{
			User add=userDetailService.createUserDetails(user);
			return new ResponseEntity<User>(add,HttpStatus.CREATED);
		}

		@PostMapping(value="/auth/login")
		public ResponseEntity<?> loginuser(@RequestBody User user)
		
		{
				boolean flag=userDetailService.validateUser(user.getUserId(), user.getUserPassword());
				System.out.println("flag :"+flag);
				 if (flag)
				 {
					 String tokenresult=generateToken(user);
					 Map<String,String> mytoken=new HashMap();
					 System.out.println("tokenresult :"+tokenresult);
					 mytoken.put("token",tokenresult);
					 
					 return new ResponseEntity<Map>(mytoken,HttpStatus.OK);
				 }
				 else
					return new ResponseEntity<String>("Invalid Credentials",HttpStatus.UNAUTHORIZED);
				
		}

		private String generateToken(User user) {
			// TODO Auto-generated method stub
			long expiry=10_000_00;
			  
			  return Jwts.builder().setIssuedAt(new Date(System.currentTimeMillis()))
					  .setSubject(user.getUserName())
					  .setExpiration(new Date(System.currentTimeMillis()+expiry))
					  .signWith(SignatureAlgorithm.HS256,"allstatekey")
					  .compact();
		}
		@PutMapping(value="/edituserdetails")
		public User editUserDetails(@RequestBody User user)
		{
			return userDetailService.editUserDetails(user);
		}
		@GetMapping(value="/getuserdetails")
		public Iterable<User> getUserDetails()
		{
			return userDetailService.getUserDetails();
		}
		@GetMapping(value="/userid/{userid}")
		public User getloginuser(@PathVariable ("userid")int userid){
			return userDetailService.getloginuser(userid);
		}
	

}



