package com.lnt.homeloan.model;

import java.util.Arrays;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Documents")

public class Documents {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Document_id",nullable = false)
	private int document_id;
	
	@OneToOne
	private User users;
	
	@OneToOne
	private Loan applicationid;
	
	@Lob
	@Column(nullable = true)
	private byte[] pancard;
	
	@Lob
	@Column(nullable = true)
	private byte[] voterId;
	
	@Lob
	@Column(nullable=true)
	private byte[] salaryslip;
	
	@Lob
	@Column(nullable = true)
	private byte[] loa;
	
	@Lob
	@Column(nullable = true)
	private byte[] noc;

	@Lob
	@Column(nullable = true)
	private byte[] Agreement_To_Sale;

	public Documents() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Documents(int document_id, User users, Loan applicationid, byte[] pancard, byte[] voterId, byte[] salaryslip,
			byte[] loa, byte[] noc, byte[] agreement_To_Sale) {
		super();
		this.document_id = document_id;
		this.users = users;
		this.applicationid = applicationid;
		this.pancard = pancard;
		this.voterId = voterId;
		this.salaryslip = salaryslip;
		this.loa = loa;
		this.noc = noc;
		Agreement_To_Sale = agreement_To_Sale;
	}



	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public byte[] getPancard() {
		return pancard;
	}

	public void setPancard(byte[] pancard) {
		this.pancard = pancard;
	}

	public byte[] getVoterId() {
		return voterId;
	}

	public void setVoterId(byte[] voterId) {
		this.voterId = voterId;
	}

	public byte[] getSalaryslip() {
		return salaryslip;
	}

	public void setSalaryslip(byte[] salaryslip) {
		this.salaryslip = salaryslip;
	}

	public byte[] getLoa() {
		return loa;
	}

	public void setLoa(byte[] loa) {
		this.loa = loa;
	}

	public byte[] getNoc() {
		return noc;
	}

	public void setNoc(byte[] noc) {
		this.noc = noc;
	}

	public byte[] getAgreement_To_Sale() {
		return Agreement_To_Sale;
	}

	public void setAgreement_To_Sale(byte[] agreement_To_Sale) {
		Agreement_To_Sale = agreement_To_Sale;
	}

	
	public int getDocument_id() {
		return document_id;
	}



	public void setDocument_id(int document_id) {
		this.document_id = document_id;
	}



	public Loan getApplicationid() {
		return applicationid;
	}



	public void setApplicationid(Loan applicationid) {
		this.applicationid = applicationid;
	}



	
	

}
