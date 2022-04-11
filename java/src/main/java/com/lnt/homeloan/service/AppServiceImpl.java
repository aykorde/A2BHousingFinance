package com.lnt.homeloan.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.lnt.homeloan.dao.AppDao;
import com.lnt.homeloan.model.Income;
import com.lnt.homeloan.model.Loan;
import com.lnt.homeloan.model.User;

@Service
public class AppServiceImpl implements AppService {

	@Autowired
	private AppDao appdao;


	@Override
	public String saveIncomeDetails(Income income, int userid) {
		if(income!=null && userid>0) {
			String result = appdao.saveIncomeDetails(income,userid);
			return result;
			}
			else {
				return "unsaved";
			}
		
		
	}


	@Override
	public String saveLoanDetails(Loan loan, int userid) {
		if(loan!=null && userid>0) {
			String result = appdao.saveLoanDetails(loan,userid);
			return result;
			}
			else {
				return "unsaved";
			}
	}


	
}
