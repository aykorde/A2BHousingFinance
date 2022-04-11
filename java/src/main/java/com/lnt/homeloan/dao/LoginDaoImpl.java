package com.lnt.homeloan.dao;


import java.util.List;

import javax.persistence.EntityManager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lnt.homeloan.model.Admin;
import com.lnt.homeloan.model.LoginEntity;
import com.lnt.homeloan.model.User;




@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private EntityManager entityManager;
	
	

	@Override
	public User verifyUser(String email) {
		try {
			List uid =entityManager.createQuery("select u.userid from User u where u.email= :email").setParameter("email", email).getResultList();
			User obj = entityManager.find(User.class, uid.get(0));
			return obj;
			}
			catch(Exception e) {
				e.printStackTrace();
				return null;
			}
	}



	@Override
	public Admin verifyAdmin(String username) {
		try {
		Admin obj = entityManager.find(Admin.class, username);
		return obj;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}







	

}
