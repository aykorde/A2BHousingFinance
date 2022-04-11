package com.lnt.homeloan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lnt.homeloan.service.AdminService;

@RestController
@RequestMapping(path = "/admin")
@CrossOrigin
public class AdminController {

	@Autowired
	private AdminService adminservice;

	
	@RequestMapping(path="/getallsfaapplication", produces="application/json")
	public List getAllallSFA() {
		List appliedusers = adminservice.getAllallSFA();
		return appliedusers;
	}
	
	@RequestMapping(path = "/approve1/{id}/",produces = "text/plain")
	public String approve1(@PathVariable("id")  String appid) {
		String result = adminservice.approve1(appid);
		return result;
	}
	
	@RequestMapping(path="/getallvsfaapplication", produces="application/json")
	public List getAllallVSFA() {
		List appliedusers = adminservice.getAllallVSFA();
		return appliedusers;
	}
	
	@RequestMapping(path = "/approve2/{id}/", produces = "text/plain")
	public String approve2(@PathVariable("id")  String appid) {
		String result = adminservice.approve2(appid);
		return result;
	}
	
	@RequestMapping(path = "/reject/{id}/", produces = "text/plain")
	public String reject(@PathVariable("id")  String appid) {
		String result = adminservice.reject(appid);
		return result;
	}
}
