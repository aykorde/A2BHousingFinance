package com.lnt.homeloan.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnt.homeloan.dao.UserDao;
import com.lnt.homeloan.model.Income;
import com.lnt.homeloan.model.Loan;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserDao userdao;

	@Override
	public Map<String, Object> getAllUserData(int userid) {
		Income income = userdao.getAllUserData(userid);
		Map<String, Object> obj= new HashMap<>();
		obj.put("income", income);
		return obj;
	}

	@Override
	public String applyLoan(String appid) {
		String result = userdao.applyLoan(appid);
		return result;
	}

	@Override
	public Loan trackstatus(String appid) {
		return userdao.trackstatus(appid);
	}

}
