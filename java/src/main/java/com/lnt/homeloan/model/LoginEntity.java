package com.lnt.homeloan.model;

import java.io.Serializable;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

//@Entity(name="Login")
public class LoginEntity{
	
	private int userid;
	
	
	private String password;
	
	private String email;
	
	
	public LoginEntity() {
		// TODO Auto-generated constructor stub
	}

	
	public LoginEntity(int userid, String password, String email) {
		super();
		this.userid = userid;
		this.password = password;
		this.email = email;
	}


	
	  public int getUserid() { return userid; }
	  
	  
	  public void setUserid(int userid) { this.userid = userid; }
	 


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "LoginEntity [userid=" + userid + ", password=" + password + ", email=" + email + "]";
	}

	
	}
	

