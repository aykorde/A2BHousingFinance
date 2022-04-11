package com.lnt.homeloan.controller;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.lnt.homeloan.config.AppConfig;
import com.lnt.homeloan.model.Income;
import com.lnt.homeloan.model.Loan;
import com.lnt.homeloan.service.AppService;
import com.sun.xml.txw2.Document;

@RestController
@RequestMapping(path = "/application")
@CrossOrigin
public class ApplicationController {

	@Autowired
	private AppService appservice;

	@PostMapping(path = "/income/{id}", consumes="application/json", produces = "text/plain")
	public String saveIncomeDetails(@RequestBody Income income, @PathVariable("id")  int userid) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		 return appservice.saveIncomeDetails(income,userid);
	
	}
	
	@PostMapping(path = "/loan/{id}", consumes="application/json", produces = "text/plain")
	public String saveLoanDetails(@RequestBody Loan loan, @PathVariable("id")  int userid) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		 return appservice.saveLoanDetails(loan,userid);
	
	}
	
	 
}
