package com.lnt.homeloan.dao;

import java.util.Date;
import java.util.List;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Repository;
import com.lnt.homeloan.model.Admin;
import com.lnt.homeloan.model.Loan;
@Repository
public class AdminDaoImpl implements AdminDao {
	
	@Autowired
	private EntityManager entityManager;
	

	@Override
	public List getAllallSFA() {
		
		List getallapplication = entityManager.createQuery("SELECT a.applicationid, b.first_name, b.last_name, a.interestrate, "
				+ "a.tenure, a.loanamount, a.maxloanamount FROM Loan a JOIN User b ON a.userid=b.userid WHERE a.status='sent for verification'").getResultList();
		
		return getallapplication;
	}



	@Override
	public String approve1(String appid, Date dvdate) {
		try {
			Loan l =entityManager.find(Loan.class, appid);
			l.setDocverificationdate(dvdate);
			l.setStatus("verified and sent for further appointment");
			entityManager.getTransaction().begin();
			entityManager.merge(l);
			entityManager.getTransaction().commit();
			return "approve";
			}
			catch(Exception e) {
				e.printStackTrace();
				entityManager.getTransaction().rollback();
				return "notapprove";
			}
	}
	


	@Override
	public List getAllallVSFA() {
		List getallapplication = entityManager.createQuery("SELECT a.applicationid, b.first_name, b.last_name, a.interestrate, "
				+ "a.tenure, a.loanamount, a.maxloanamount FROM Loan a JOIN User b ON a.userid=b.userid WHERE a.status='verified and sent for further appointment'").getResultList();
		
		return getallapplication;
	}
	
	@Override
	public String approve2(String appid) {
		try {
			Loan l =entityManager.find(Loan.class, appid);
			List<Long> list =entityManager.createQuery("SELECT l.accno FROM Loan l ORDER BY l.accno DESC").getResultList();
			if(list.get(0)==0) {
				l.setAccno(2124000000);
			}
			else {
			l.setAccno(list.get(0)+1);
			}
			l.setStatus("approved");
			entityManager.getTransaction().begin();
			entityManager.merge(l);
			entityManager.getTransaction().commit();
			return "approve";
			}
			catch(Exception e) {
				e.printStackTrace();
				entityManager.getTransaction().rollback();
				return "notapprove";
			}
	}



	@Override
	public String reject(String appid) {
		try {
			Loan l =entityManager.find(Loan.class, appid);
			l.setStatus("rejected");
			entityManager.getTransaction().begin();
			entityManager.merge(l);
			entityManager.getTransaction().commit();
			return "reject";
			}
			catch(Exception e) {
				e.printStackTrace();
				entityManager.getTransaction().rollback();
				return "notreject";
			}
	}
}
