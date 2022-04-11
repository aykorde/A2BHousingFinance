package com.lnt.homeloan.dao;

import java.util.Date;
import java.util.List;


import com.lnt.homeloan.model.Admin;
import com.lnt.homeloan.model.Loan;

public interface AdminDao {


	List getAllallSFA();

	String approve1(String appid, Date dvdate);

	List getAllallVSFA();

	String approve2(String appid);

	String reject(String appid);

}
