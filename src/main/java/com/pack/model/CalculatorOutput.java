package com.pack.model;

public class CalculatorOutput {
	Integer loanAmount;
	Integer durationInYear;
	Integer totalPayable;
	String interestRate;
	Integer emi;
	
	public CalculatorOutput() {
		// TODO Auto-generated constructor stub
	}

	public CalculatorOutput(Integer loanAmount, Integer durationInYear, Integer totalPayable, String interestRate,
			Integer emi) {
		super();
		this.loanAmount = loanAmount;
		this.durationInYear = durationInYear;
		this.totalPayable = totalPayable;
		this.interestRate = interestRate;
		this.emi = emi;
	}

	public Integer getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Integer loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Integer getDurationInYear() {
		return durationInYear;
	}

	public void setDurationInYear(Integer durationInYear) {
		this.durationInYear = durationInYear;
	}

	public Integer getTotalPayable() {
		return totalPayable;
	}

	public void setTotalPayable(Integer totalPayable) {
		this.totalPayable = totalPayable;
	}

	public String getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}

	public Integer getEmi() {
		return emi;
	}

	public void setEmi(Integer emi) {
		this.emi = emi;
	}
	
	
	
}
