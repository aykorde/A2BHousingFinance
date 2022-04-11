package com.lnt.homeloan.dao;

import java.util.List;
import java.util.Map;

import com.lnt.homeloan.model.Income;
import com.lnt.homeloan.model.Loan;

public interface UserDao {

	Income getAllUserData(int userid);

	String applyLoan(String appid);

	Loan trackstatus(String appid);

}
