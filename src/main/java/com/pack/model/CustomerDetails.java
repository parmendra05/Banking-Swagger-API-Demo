package com.pack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CustomerDetails {

	@Id
	@GeneratedValue
	Integer accountNo;
	String customerName;
	String address;
	Integer ballance;
	String accountStatus;
	
	
	public CustomerDetails() {
		// TODO Auto-generated constructor stub
	}


	public CustomerDetails(Integer accountNo, String customerName, String address, Integer ballance,
			String accountStatus) {
		super();
		this.accountNo = accountNo;
		this.customerName = customerName;
		this.address = address;
		this.ballance = ballance;
		this.accountStatus = accountStatus;
	}


	public Integer getAccountNo() {
		return accountNo;
	}


	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Integer getBallance() {
		return ballance;
	}


	public void setBallance(Integer ballance) {
		this.ballance = ballance;
	}


	public String getAccountStatus() {
		return accountStatus;
	}


	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	
}
