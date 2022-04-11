package com.lnt.homeloan.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.lnt.homeloan.dao.LoginDao;
import com.lnt.homeloan.model.Admin;
import com.lnt.homeloan.model.LoginEntity;
import com.lnt.homeloan.model.User;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao logindao;

	@Override
	public int verifyUser(LoginEntity login) {
		if (login != null) {
			User le = logindao.verifyUser(login.getEmail());
			if (le != null) {
				String eidcheck = le.getEmail();
				String passcheck = le.getPassword();
				if (login.getEmail().equals(eidcheck)&& login.getPassword().equals(passcheck)) {
					System.out.println("verifed");
					System.out.println(le.getUserid());
					return le.getUserid();
				} else {
					System.out.println("not a verifed user");
					return 0;
				}
			}

			else {
				System.out.println("user not found");
				return 0;
			}
		}
		return 0;
	}

	@Override
	public int verifyAdmin(Admin admin) {
		if (admin != null) {
			Admin le = logindao.verifyAdmin(admin.getUsername());
			if (le != null) {
				String uidcheck = le.getUsername();
				String passcheck = le.getPassword();
				if (admin.getUsername().equals(uidcheck) && admin.getPassword().equals(passcheck)) {
					System.out.println("verifed");
					return 1;
				} else {
					System.out.println("not verifed ");
					return 0;
				}
			}

			else {
				System.out.println("admin not found");
				return 0;
			}
		}
		return 0;
	}

}
