package com.lnt.homeloan.controller;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lnt.homeloan.model.Loan;
import com.lnt.homeloan.service.UserService;

@RestController
@RequestMapping(path = "/user")
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userservice;

	@RequestMapping(path = "/applynow/{id}", produces = "application/json")
	public Map<String, Object> getAllUserData(@PathVariable("id")  int userid) {
		Map<String, Object> userdata = userservice.getAllUserData(userid);
		return userdata;
		
	}
	
	@RequestMapping(path = "/applyloan/{id}", produces = "text/plain")
	public String applyLoan(@PathVariable("id")  String appid) {
		String result = userservice.applyLoan(appid);
		return result;
		
	}
	
	
	  @RequestMapping(path = "/trackstatus/{id}", produces = "application/json") 
	  public Loan trackStatus(@PathVariable("id") String appid) { 
		   return (userservice.trackstatus(appid)); 
		   
	  
	  }
	 
	

}
