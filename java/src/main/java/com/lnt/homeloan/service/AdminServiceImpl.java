package com.lnt.homeloan.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lnt.homeloan.dao.AdminDao;
import com.lnt.homeloan.model.Admin;
import com.lnt.homeloan.model.User;


@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDao admindao;

	@Override
	public List getAllallSFA() {
		List appliedusers =admindao.getAllallSFA();
		
		return appliedusers;
	}

	@Override
	public String approve1(String appid) {
		Date dvdate = dvDate();
		String result= admindao.approve1(appid,dvdate);
		return result;
	}

	@Override
	public List getAllallVSFA() {
        List appliedusers =admindao.getAllallVSFA();
		return appliedusers;
	}

	@Override
	public String approve2(String appid) {
		String result= admindao.approve2(appid);
		return result;
	}

	@Override
	public String reject(String appid) {
		String result= admindao.reject(appid);
		return result;
	}

	public static Date dvDate()
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, 3);
        return cal.getTime();
    }
}
