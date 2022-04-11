package com.lnt.homeloan.service;

import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.lnt.homeloan.model.Income;
import com.lnt.homeloan.model.Loan;

public interface AppService {

	String saveIncomeDetails(Income income, int userid);

	String saveLoanDetails(Loan loan, int userid);

	

}
