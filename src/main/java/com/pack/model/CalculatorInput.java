package com.pack.model;

public class CalculatorInput {

	Integer loanAmount;
	Integer durationInMonth;
	
	public CalculatorInput() {
		// TODO Auto-generated constructor stub
	}

	
	public CalculatorInput(Integer loanAmount, Integer durationInMonth) {
		super();
		this.loanAmount = loanAmount;
		this.durationInMonth = durationInMonth;
	}


	public Integer getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Integer loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Integer getDurationInMonth() {
		return durationInMonth;
	}

	public void setDurationInMonth(Integer durationInMonth) {
		this.durationInMonth = durationInMonth;
	}

	

}
