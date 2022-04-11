package com.lnt.homeloan.service;

import java.util.List;


import com.lnt.homeloan.model.Admin;
import com.lnt.homeloan.model.Loan;
import com.lnt.homeloan.model.LoginEntity;

public interface AdminService {

	public List getAllallSFA();

	public String approve1(String userid);

	public List getAllallVSFA();

	String approve2(String appid);

	public String reject(String appid);

}
