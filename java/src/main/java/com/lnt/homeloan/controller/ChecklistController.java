package com.lnt.homeloan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lnt.homeloan.config.AppConfig;
import com.lnt.homeloan.model.Documents;
import com.lnt.homeloan.model.Income;
import com.lnt.homeloan.model.Loan;
import com.lnt.homeloan.service.ChecklistService;

@RestController
@RequestMapping(path = "/document")
@CrossOrigin
public class ChecklistController {
	@Autowired
	private ChecklistService checklistservice;
	
	@RequestMapping(path = "/checklist/{id}")
	public List GenerateChecklist(@PathVariable("id")  int userid) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		 return checklistservice.GenerateChecklist(userid);
	 
	
	}
	
	@RequestMapping(path = "/viewall/{id}")
	public List viewAllDocs(@PathVariable("id")  String appid) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		 return checklistservice.viewAllDocs(appid);
	 
	
	}

}
