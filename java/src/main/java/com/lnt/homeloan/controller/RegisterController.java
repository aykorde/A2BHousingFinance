package com.lnt.homeloan.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lnt.homeloan.config.AppConfig;
import com.lnt.homeloan.model.User;
import com.lnt.homeloan.service.RegisterService;

@RestController
@RequestMapping(path = "/register")
@CrossOrigin
public class RegisterController {
	
	@Autowired
	private RegisterService registerservice;

	@PostMapping(path = "/saveuser", consumes="application/json", produces = "text/plain")
	public String saveUser(@RequestBody User user) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println(user);
		int result = registerservice.saveUser(user);
		if (result == 1) {
			return "saved";
		}
		return "unsaved";
	}

}
