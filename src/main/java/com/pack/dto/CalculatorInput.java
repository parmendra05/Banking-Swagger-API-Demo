package com.pack.dto;

public class CalculatorInput {

	float loanAmount;
	float durationInMonth;
	
	public CalculatorInput() {
		// TODO Auto-generated constructor stub
	}

	
	public CalculatorInput(float loanAmount, float durationInMonth) {
		super();
		this.loanAmount = loanAmount;
		this.durationInMonth = durationInMonth;
	}


	public float getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(float loanAmount) {
		this.loanAmount = loanAmount;
	}

	public float getDurationInMonth() {
		return durationInMonth;
	}

	public void setDurationInMonth(float durationInMonth) {
		this.durationInMonth = durationInMonth;
	}

	

}
