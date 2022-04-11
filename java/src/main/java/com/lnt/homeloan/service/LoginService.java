package com.lnt.homeloan.service;

import com.lnt.homeloan.model.Admin;
import com.lnt.homeloan.model.LoginEntity;

public interface LoginService {
	
	public int verifyUser(LoginEntity login);

	public int verifyAdmin(Admin admin);

}
