package com.pack.dto;

public class CalculatorOutput {
	float loanAmount;
	float durationInYear;
	float totalPayable;
	float interestRate;
	float emi;
	
	public CalculatorOutput() {
		// TODO Auto-generated constructor stub
	}

	public CalculatorOutput(float loanAmount, float durationInYear, float totalPayable, float interestRate,
			Integer emi) {
		super();
		this.loanAmount = loanAmount;
		this.durationInYear = durationInYear;
		this.totalPayable = totalPayable;
		this.interestRate = interestRate;
		this.emi = emi;
	}

	public float getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(float loanAmount) {
		this.loanAmount = loanAmount;
	}

	public float getDurationInYear() {
		return durationInYear;
	}

	public void setDurationInYear(float durationInYear) {
		this.durationInYear = durationInYear;
	}

	public float getTotalPayable() {
		return totalPayable;
	}

	public void setTotalPayable(float totamount) {
		this.totalPayable = totamount;
	}

	public float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}

	public float getEmi() {
		return emi;
	}

	public void setEmi(float emi) {
		this.emi = emi;
	}
	
	
	
}
