package com.lnt.homeloan.dao;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.lnt.homeloan.model.Documents;
import com.lnt.homeloan.model.Income;
import com.lnt.homeloan.model.Loan;
import com.lnt.homeloan.model.User;

@Repository
public class AppDaoImpl implements AppDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public String saveIncomeDetails(Income income, int userid) {
		try {
			entityManager.getTransaction().begin();
			User u = entityManager.find(User.class, userid);
			List<String> appid = entityManager.createQuery("SELECT l.applicationid FROM Loan l JOIN User u ON l.userid= u.userid").getResultList();
			Loan l = entityManager.find(Loan.class, appid.get(0));
			income.setUserid(u);
			income.setApplicationid(l);
			entityManager.persist(income);
			entityManager.getTransaction().commit();
			System.out.println("income details saved");
			return "saved";
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			System.out.println("income details not saved");
			return "unsaved";
		}

	}

	@Override
	public String saveLoanDetails(Loan loan, int userid) {
		try {
			entityManager.getTransaction().begin();
			User u = entityManager.find(User.class, userid);
			loan.setUserid(u);
			entityManager.persist(loan);
			entityManager.getTransaction().commit();
			System.out.println("loan details saved");
			return "saved";
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			System.out.println("loan details not saved");
			return "unsaved";
		}
	}

	
}
