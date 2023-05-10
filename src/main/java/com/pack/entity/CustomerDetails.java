package com.pack.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CustomerDetails {

	@Id
	@GeneratedValue
	Integer customer_Id;
	String customerName;
	Integer accountNo;
	String address;
	Integer ballance;
	String accountStatus;

	public Integer getCustomer_Id() {
		return customer_Id;
	}

	public void setCustomer_Id(Integer customer_Id) {
		this.customer_Id = customer_Id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
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
