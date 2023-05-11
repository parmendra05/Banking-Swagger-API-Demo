package com.pack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.dto.CalculatorInput;
import com.pack.dto.CalculatorOutput;
import com.pack.dto.CustomerRequestPayload;
import com.pack.entity.CustomerDetails;
import com.pack.repo.AccountRepository;
import com.pack.util.AppConstant;

@Service
public class AccountService {

	@Autowired
	private AccountRepository repo;

	@Autowired
	AccountService service;

	public CustomerDetails saveData(CustomerRequestPayload request) {

		CustomerDetails details = new CustomerDetails();
		details.setCustomerName(request.getCustomerName());
		details.setAddress(request.getAddress());
		details.setBallance(request.getBallance());

		CustomerDetails obj = repo.save(details);
		Integer createdAccount = 10100500 + obj.getCustomer_Id();
		obj.setAccountNo(createdAccount);
		obj.setAccountStatus(AppConstant.ACTIVE);

		return repo.save(obj);

	}

	public CustomerDetails updateData(CustomerDetails details) {
		return repo.save(details);
	}

	public CustomerDetails getData(Integer account) {
		return repo.findByAccountNo(account);
	}

	public String deleteCustomer(Integer account) {
		CustomerDetails customer = repo.findByAccountNo(account);
		if (customer != null) {
			repo.deleteById(account);
			return "Data Deleted Account of " + account;
		}
		return "Provided account doesn't exist";
	}

	public String activateCustomer(Integer account) {
		CustomerDetails cd = repo.findByAccountNo(account);
		if (cd.getAccountStatus() == AppConstant.ACTIVE)
			return AppConstant.ACTIVE_STATUS;
		else {
			cd.setAccountStatus(AppConstant.ACTIVE);
			service.updateData(cd);
			return AppConstant.ACTIVE_SUCCESS_MSG + account;
		}
	}

	public String deactivateCustomer(Integer account) {
		CustomerDetails cd = repo.findByAccountNo(account);
		if (cd.getAccountStatus() == AppConstant.CLOSED)
			return AppConstant.CLOSED_STATUS;
		else {
			cd.setAccountStatus(AppConstant.CLOSED);
			service.updateData(cd);
			return AppConstant.CLOSED_SUCCESS_MSG + account;
		}

	}

	public CalculatorOutput calculatorOut(CalculatorInput in) {

		float amount = in.getLoanAmount();
		float duration = in.getDurationInMonth();
		float totamount = calculateAmount(amount, duration);

		CalculatorOutput output = new CalculatorOutput();

		output.setLoanAmount(amount);
		output.setDurationInYear(duration);
		output.setTotalPayable(totamount);
		output.setEmi(totamount / duration);
		output.setInterestRate(11); // Hard Cord
		return output;
	}

	// Note : we can write bank_interest wth Hard Coded value
	float calculateAmount(float amount, float duration) {
		float bank_interest = 11; // Hard Cord
		float total_Interest = (amount * bank_interest * (duration / 12)) / 100;
		return total_Interest + amount;
	}

}
