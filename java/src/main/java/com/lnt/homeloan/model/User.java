package com.lnt.homeloan.model;



import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@SecondaryTable(name = "Login", pkJoinColumns = {@PrimaryKeyJoinColumn(name = "userid", referencedColumnName = "userid")})
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable = false)
	private int userid;
	
	@Column(nullable = false)
	private String first_name;
	
	@Column(nullable = false)
	private String middle_name;
	
	@Column(nullable = false)
	private String last_name;
	
	
	@Column(nullable = false,table="Login")
	private String email;
	
	@Column(nullable = false ,table="Login")
	private String password;
	
	@Column(nullable = false)
	private String phonenumber;
	
	@JsonProperty
	@Column(nullable = true)
	private Date dob;
	
	 @Enumerated(EnumType.STRING)
	 @Column(length = 10, nullable = false)
	 private Gender gender;
	 
	 @Column(nullable = false)
	 private String nationality;
	 
	 @Column(nullable = false,unique=true)
	 private String aadharcard;
	 
	 @Column(nullable = false,unique=true)
	 private String pancard;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(int userid, String first_name, String middle_name, String last_name, String email, String password,
			String phonenumber, Date dob, Gender gender, String nationality, String aadharcard, String pancard) {
		super();
		this.userid = userid;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.phonenumber = phonenumber;
		this.dob = dob;
		this.gender = gender;
		this.nationality = nationality;
		this.aadharcard = aadharcard;
		this.pancard = pancard;
	}







	public int getUserid() {
		return userid;
	}



	public void setUserid(int userid) {
		this.userid = userid;
	}



	public String getFirst_name() {
		return first_name;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}



	public String getMiddle_name() {
		return middle_name;
	}



	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}



	public String getLast_name() {
		return last_name;
	}



	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	



	public String getPhonenumber() {
		return phonenumber;
	}







	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}







	public Date getDob() {
		return dob;
	}



	public void setDob(Date dob) {
		this.dob = dob;
	}



	public Gender getGender() {
		return gender;
	}



	public void setGender(Gender gender) {
		this.gender = gender;
	}



	public String getNationality() {
		return nationality;
	}



	public void setNationality(String nationality) {
		this.nationality = nationality;
	}



	public String getAadharcard() {
		return aadharcard;
	}



	public void setAadharcard(String aadharcard) {
		this.aadharcard = aadharcard;
	}



	public String getPancard() {
		return pancard;
	}



	public void setPancard(String pancard) {
		this.pancard = pancard;
	}







	@Override
	public String toString() {
		return "User [userid=" + userid + ", first_name=" + first_name + ", middle_name=" + middle_name + ", last_name="
				+ last_name + ", email=" + email + ", password=" + password + ", phonenumber=" + phonenumber + ", dob="
				+ dob + ", gender=" + gender + ", nationality=" + nationality + ", aadharcard=" + aadharcard
				+ ", pancard=" + pancard + "]";
	}



	

	
}