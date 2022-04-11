package com.lnt.homeloan.model;

import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Loan")
@SecondaryTable(name = "LoanApplication", pkJoinColumns = {@PrimaryKeyJoinColumn(name = "applicationid", referencedColumnName = "applicationid")})
public class Loan {
	@Id
	@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)")
	private String applicationid;
	
	@OneToOne
	private User userid;
	
	@Column(name="Maximum_Loan_Amount",nullable = false)
	private int maxloanamount;
	
	@Column(name="Interest_Rate",nullable = false)
	private float interestrate;
	
	@Column(length= 100,name="Tenure")
	private int tenure;
	
	@Column(name="Loan_Amount",nullable = false)
	private int loanamount;
	
	@Column(name="Account_No",nullable = true)
	private long accno;
	
	@Column(table="LoanApplication",name="Status",nullable = false)
	private  String status="not applied";
	
	@Column(table="LoanApplication",name="Application_Date",nullable = true)
	private Date applieddate;
	
	@Column(table="LoanApplication", name="Document_Verification_Date",nullable = true)
	private Date docverificationdate;

	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	Loan(String applicationid, User userid, int maxloanamount, float interestrate, int tenure, int loanamount,
			long accno, String status, Date applieddate, Date docverificationdate) {
		super();
		this.applicationid = applicationid;
		this.userid = userid;
		this.maxloanamount = maxloanamount;
		this.interestrate = interestrate;
		this.tenure = tenure;
		this.loanamount = loanamount;
		this.accno = accno;
		this.status = status;
		this.applieddate = applieddate;
		this.docverificationdate = docverificationdate;
	}

	public String getApplicationid() {
		return applicationid;
	}

	public void setApplicationid(String applicationid) {
		this.applicationid = applicationid;
	}

	public User getUserid() {
		return userid;
	}

	public void setUserid(User userid) {
		this.userid = userid;
	}

	public int getMaxloanamount() {
		return maxloanamount;
	}

	public void setMaxloanamount(int maxloanamount) {
		this.maxloanamount = maxloanamount;
	}

	public float getInterestrate() {
		return interestrate;
	}

	public void setInterestrate(float interestrate) {
		this.interestrate = interestrate;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public int getLoanamount() {
		return loanamount;
	}

	public void setLoanamount(int loanamount) {
		this.loanamount = loanamount;
	}

	public long getAccno() {
		return accno;
	}

	public void setAccno(long accno) {
		this.accno = accno;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getApplieddate() {
		return applieddate;
	}

	public void setApplieddate(Date applieddate) {
		this.applieddate = applieddate;
	}

	public Date getDocverificationdate() {
		return docverificationdate;
	}

	public void setDocverificationdate(Date docverificationdate) {
		this.docverificationdate = docverificationdate;
	}

	

	
	

	










}