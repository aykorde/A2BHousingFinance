package com.lnt.homeloan.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.lnt.homeloan.dao.RegisterDao;
import com.lnt.homeloan.model.User;

@Service
public class RegisterServiceImpl implements RegisterService{
	
	@Autowired
	private RegisterDao registerdao;

	@Override
	public int saveUser(User user) {
		if (user != null) {
			
		int result = registerdao.saveUser(user);

		if(result==1) {
			System.out.println("saved");
			return 1;
		
		}
		
		else {
			System.out.println("not saved");
			return 0;
		}
	
		}
		return 0;
	}
}
