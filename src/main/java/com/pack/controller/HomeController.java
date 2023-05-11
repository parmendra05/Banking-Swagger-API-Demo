package com.pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.dto.CalculatorInput;
import com.pack.dto.CalculatorOutput;
import com.pack.dto.CustomerRequestPayload;
import com.pack.entity.CustomerDetails;
import com.pack.service.AccountService;

@RestController
@RequestMapping("api")
public class HomeController {

	@Autowired
	private AccountService service;

	@PostMapping("/createAccount")
	public ResponseEntity<CustomerDetails> saveCustomer(@RequestBody CustomerRequestPayload request) {
		CustomerDetails details = service.saveData(request);
		return new ResponseEntity<>(details, HttpStatus.CREATED);
	}

	@GetMapping("/customer-details/{accountNo}")
	public ResponseEntity<CustomerDetails> getCustomer(@PathVariable("accountNo") Integer account) {

		CustomerDetails details = service.getData(account);
		return new ResponseEntity<>(details, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{accountNo}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("accountNo") Integer account) {
		String response = service.deleteCustomer(account);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PatchMapping("/activate/{accountNo}")
	public ResponseEntity<String> activateCustomer(@PathVariable("accountNo") Integer account) {
		String response = service.activateCustomer(account);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PatchMapping("/close/{accountNo}")
	public ResponseEntity<String> deactivateCustomer(@PathVariable("accountNo") Integer account) {
		String response = service.deactivateCustomer(account);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/calculator")
	public CalculatorOutput calculator(@RequestBody CalculatorInput input) {
		return service.calculatorOut(input);
	}

}
