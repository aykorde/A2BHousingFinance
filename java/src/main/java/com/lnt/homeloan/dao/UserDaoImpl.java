package com.lnt.homeloan.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lnt.homeloan.model.Income;
import com.lnt.homeloan.model.Loan;
import com.lnt.homeloan.model.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public Income getAllUserData(int userid) {
		User u = entityManager.find(User.class, userid);
		List<Integer> incomeid = entityManager.createQuery("SELECT i.incomeid FROM Income i JOIN User u ON i.userid= :userid").setParameter("userid", u).getResultList();
		Income income= entityManager.find(Income.class, incomeid.get(incomeid.size()-1));
		
		return income;
	}

	@Override
	public String applyLoan(String appid) {
		try {
			Loan l =entityManager.find(Loan.class, appid);
			l.setApplieddate(new Date());
			l.setStatus("sent for verification");
			entityManager.getTransaction().begin();
			entityManager.merge(l);
			entityManager.getTransaction().commit();
			return "applied";
			}
			catch(Exception e) {
				e.printStackTrace();
				entityManager.getTransaction().rollback();
				return "notapplied";
			}
	}

	@Override
	public Loan trackstatus(String appid) {
		Loan loan= entityManager.find(Loan.class, appid);
		return loan;
	}

}
