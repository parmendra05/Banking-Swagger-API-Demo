package com.pack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.dto.CalculatorInput;
import com.pack.dto.CalculatorOutput;
import com.pack.dto.CustomerRequestPayload;
import com.pack.entity.CustomerDetails;
import com.pack.repo.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository repo;

	public CustomerDetails saveData(CustomerRequestPayload request) {
		
		CustomerDetails details = new CustomerDetails();
		details.setCustomerName(request.getCustomerName());
		details.setAddress(request.getAddress());
		details.setBallance(request.getBallance());
		
		CustomerDetails obj=repo.save(details);
		Integer createdAccount=10100500+obj.getCustomer_Id();
		obj.setAccountNo(createdAccount);
		obj.setAccountStatus("Active");
		
		return repo.save(obj);

	}

	public CustomerDetails updateData(CustomerDetails details) {
		return repo.save(details);
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
		
		float amount = in.getLoanAmount();
		float duration = in.getDurationInMonth();
		float totamount = calculateAmount(amount, duration);
		
		CalculatorOutput output = new CalculatorOutput();
		
		output.setLoanAmount( amount);
		output.setDurationInYear(duration);
		output.setTotalPayable(totamount);
		output.setEmi(totamount / duration);
		output.setInterestRate(11);		// Hard Cord
		return output;
	}
	// Note : we can write bank_interest wth Hard Coded value 
	float calculateAmount(float amount,float duration) {
		float bank_interest =11;	// Hard Cord
		float total_Interest= (amount*bank_interest*(duration/12))/100;
		return total_Interest+amount;
	}

}
