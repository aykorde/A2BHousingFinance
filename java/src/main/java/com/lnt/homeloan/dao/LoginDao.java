package com.lnt.homeloan.dao;

import com.lnt.homeloan.model.Admin;
import com.lnt.homeloan.model.LoginEntity;
import com.lnt.homeloan.model.User;

public interface LoginDao {

	public User verifyUser(String email);

	public Admin verifyAdmin(String username);

}
