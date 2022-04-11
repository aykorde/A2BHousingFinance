package com.lnt.homeloan.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lnt.homeloan.model.Loan;
import com.lnt.homeloan.model.User;

@Repository
public class MailDaoImpl implements MailDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public String getpassword(String emailid) {

		List<String> pass = entityManager.createQuery("SELECT u.password FROM User u WHERE u.email= :emailid").setParameter("emailid", emailid).getResultList();
		if (pass.size()==1) {
			return pass.get(0);
		} else {
			return null;
		}
	}

}
