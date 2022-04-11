package com.lnt.homeloan.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Embeddable
@Table(name="Income")

public class Income {
	
	@OneToOne
	private User userid;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="income_id",nullable = false)
	private int incomeid;
	
	
	@OneToOne
	private Loan applicationid;
	
	@Column(name="Property_location",nullable = false)
	private String propertylocation;
	
	@Column(name="Property_name",nullable = false)
	private String propertyname;
	
	@Column(name="estimated_amout",nullable = false)
	private int estimatedamount;
	
	@Column(name="employment_type",nullable = false)
	private String employmenttype;
	
	@Column(name="retirement_age",nullable = false)
	private int retirementage;
	
	@Column(name="organization_type",nullable = false)
	private String organizationtype;
	
	@Column(name="employer_name",nullable = false)
	private String employername;

	public Income() {
		super();
		// TODO Auto-generated constructor stub
	}

	Income(User userid, int incomeid, Loan applicationid, String propertylocation, String propertyname,
			int estimatedamount, String employmenttype, int retirementage, String organizationtype,
			String employername) {
		super();
		this.userid = userid;
		this.incomeid = incomeid;
		this.applicationid = applicationid;
		this.propertylocation = propertylocation;
		this.propertyname = propertyname;
		this.estimatedamount = estimatedamount;
		this.employmenttype = employmenttype;
		this.retirementage = retirementage;
		this.organizationtype = organizationtype;
		this.employername = employername;
	}


	public User getUserid() {
		return userid;
	}

	public void setUserid(User userid) {
		this.userid = userid;
	}

	public int getIncomeid() {
		return incomeid;
	}

	public void setIncomeid(int incomeid) {
		this.incomeid = incomeid;
	}

	public Loan getApplicationid() {
		return applicationid;
	}

	public void setApplicationid(Loan applicationid) {
		this.applicationid = applicationid;
	}

	public String getPropertylocation() {
		return propertylocation;
	}

	public void setPropertylocation(String propertylocation) {
		this.propertylocation = propertylocation;
	}

	public String getPropertyname() {
		return propertyname;
	}

	public void setPropertyname(String propertyname) {
		this.propertyname = propertyname;
	}

	public int getEstimatedamount() {
		return estimatedamount;
	}

	public void setEstimatedamount(int estimatedamount) {
		this.estimatedamount = estimatedamount;
	}

	public String getEmploymenttype() {
		return employmenttype;
	}

	public void setEmploymenttype(String employmenttype) {
		this.employmenttype = employmenttype;
	}

	public int getRetirementage() {
		return retirementage;
	}

	public void setRetirementage(int retirementage) {
		this.retirementage = retirementage;
	}

	public String getOrganizationtype() {
		return organizationtype;
	}

	public void setOrganizationtype(String organizationtype) {
		this.organizationtype = organizationtype;
	}

	public String getEmployername() {
		return employername;
	}

	public void setEmployername(String employername) {
		this.employername = employername;
	}
	
	

	
	

}