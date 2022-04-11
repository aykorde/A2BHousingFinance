package com.lnt.homeloan.dao;

import java.util.List;

import javax.persistence.EntityManager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lnt.homeloan.model.Loan;
import com.lnt.homeloan.model.User;

@Repository
public class ChecklistDaoImpl implements ChecklistDao {

	@Autowired
	private EntityManager entityManager;
	@Override
	public List GenerateChecklist(int userid) {
		User u = entityManager.find(User.class, userid);
		List docs = entityManager.createQuery("SELECT f.pancard, f.voterId, f.salaryslip, f.loa, f.noc, f.Agreement_To_Sale FROM Documents f WHERE f.users= :userid").setParameter("userid", u).getResultList();
		
		return docs;
	}
	@Override
	public List viewAllDocs(String appid) {
		Loan l = entityManager.find(Loan.class, appid);
		List docs = entityManager.createQuery("SELECT f.pancard, f.voterId, f.salaryslip, f.loa, f.noc, f.Agreement_To_Sale FROM Documents f WHERE f.applicationid= :appid").setParameter("appid", l).getResultList();
		
		return docs;
	}

}
