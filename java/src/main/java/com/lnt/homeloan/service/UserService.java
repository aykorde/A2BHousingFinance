package com.lnt.homeloan.service;

import java.util.List;
import java.util.Map;

import com.lnt.homeloan.model.Loan;

public interface UserService {

	Map<String, Object> getAllUserData(int userid);

	String applyLoan(String appid);

	Loan trackstatus(String appid);

}
