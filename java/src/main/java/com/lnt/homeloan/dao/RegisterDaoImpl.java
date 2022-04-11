package com.lnt.homeloan.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lnt.homeloan.model.LoginEntity;
import com.lnt.homeloan.model.User;

@Repository
public class RegisterDaoImpl implements RegisterDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public int saveUser(User user) {

			try {
				entityManager.getTransaction().begin();
				entityManager.persist(user);
				entityManager.getTransaction().commit();
				return 1;
			} catch (Exception e) {
				e.printStackTrace();
				entityManager.getTransaction().rollback();
				return 0;
			}
	}

}
