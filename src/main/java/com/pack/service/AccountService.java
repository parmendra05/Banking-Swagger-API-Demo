package com.pack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.model.CalculatorInput;
import com.pack.model.CalculatorOutput;
import com.pack.model.CustomerDetails;
import com.pack.repo.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository repo;

	public CustomerDetails saveData(CustomerDetails details) {
		// TODO Auto-generated method stub
		return repo.saveAndFlush(details);
		
	}

	public CustomerDetails getData(Integer account) {
		// TODO Auto-generated method stub
		return repo.findByAccountNo(account);
	}

	public void deleteData(Integer account) {
		// TODO Auto-generated method stub
		repo.deleteById(account);
		
	}

	public CalculatorOutput calculatorOut(CalculatorInput in) {
		Integer amount=in.getLoanAmount();
		Integer duration=in.getDurationInMonth();
		Integer totamount=amount+amount/10;
		CalculatorOutput op=new CalculatorOutput();
		op.setLoanAmount(amount);
		op.setDurationInYear(duration);
		op.setTotalPayable(totamount);
		op.setEmi(totamount/duration);
		op.setInterestRate("10%");
		return op;
	}
	
}
