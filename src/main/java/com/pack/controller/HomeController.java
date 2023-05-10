package com.pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pack.dto.CalculatorInput;
import com.pack.dto.CalculatorOutput;
import com.pack.dto.CustomerRequestPayload;
import com.pack.entity.CustomerDetails;
import com.pack.service.AccountService;

@RestController
public class HomeController {

	@Autowired
	private AccountService service;

	@PostMapping("/createAccount")
	public CustomerDetails saveCustomer(@RequestBody CustomerRequestPayload request) {

		return service.saveData(request);
	}

	@GetMapping("/customer-details/{accountNo}")
	public CustomerDetails getCustomer(@PathVariable("accountNo") Integer account) {

		return service.getData(account);
	}

	@DeleteMapping("/delete/{accountNo}")
	public String deleteCustomer(@PathVariable("accountNo") Integer account) {
		CustomerDetails cd = service.getData(account);
		if (cd != null) {
			service.deleteData(account);
			return "Data Deleted Account of " + account;
		}
		return "Provided account doesn't exist";
	}

	@PatchMapping("/activate/{accountNo}")
	public String activateCustomer(@PathVariable("accountNo") Integer account) {
		CustomerDetails cd = service.getData(account);
		if (cd.getAccountStatus() == "Active")
			return "Account already Active , Dont worry";
		else {
			cd.setAccountStatus("Active");
			service.updateData(cd);
			return "account activation successfull " + account;
		}
	}

	@PatchMapping("/close/{accountNo}")
	public String deactivateCustomer(@PathVariable("accountNo") Integer account) {
		CustomerDetails cd = service.getData(account);
		if (cd.getAccountStatus() == "Closed")
			return "Account already Closed , Dont worry";
		else {
			cd.setAccountStatus("Closed");
			service.updateData(cd);
			return "account de-activation successfull " + account;
		}
	}

	@PostMapping("/calculator")
	public CalculatorOutput calculator(@RequestBody CalculatorInput input) {
		return service.calculatorOut(input);
	}

}
