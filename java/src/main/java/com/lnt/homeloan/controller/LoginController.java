package com.lnt.homeloan.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.lnt.homeloan.config.AppConfig;
import com.lnt.homeloan.model.Admin;
import com.lnt.homeloan.model.LoginEntity;
import com.lnt.homeloan.model.User;
import com.lnt.homeloan.service.LoginService;
import com.lnt.homeloan.service.MailService;
import com.lnt.homeloan.service.MailServiceImpl;


@RestController
@RequestMapping(path = "/login")
@CrossOrigin("*")
public class LoginController {

	@Autowired
	private LoginService loginservice;

	@RequestMapping(path = "/verifyuser", consumes="application/json")
	public int verifyUser(@RequestBody LoginEntity login) {
		System.out.println(login);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		int result =loginservice.verifyUser(login);
		System.out.println(result);
		return result;
		
	}
	
	@RequestMapping(path = "/verifyadmin", consumes="application/json", produces = "text/plain")
	public String verifyAdmin(@RequestBody Admin admin) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		int result = loginservice.verifyAdmin(admin);
		if (result == 1) {
			return "valid";

	}
		return "invalid";
	}
	
	@RequestMapping(path ="/forgetpassword/{emailid}/", produces = "text/plain")
	public String forgetPassword(@PathVariable("emailid") String emailid) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		MailService mailService = context.getBean("mailService", MailServiceImpl.class);

		String result = mailService.sendEmail(emailid);
		context.close();
		return result;
	}
	
	

}

/*@ModelAttribut
 * map.addAttribute("name", login.getUserid()); map.addAttribute("pwd",
 * login.getPassword()); Map<String,Integer> lo = new HashMap<>();
 * lo.put("aish",1); lo.put("korde",2); map.addAttribute("jasonlist",lo); return
 * new ModelAndView("redirect: http://localhost:4200/welcome", map);
 */