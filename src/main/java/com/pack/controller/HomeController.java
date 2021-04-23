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

import com.pack.model.CalculatorInput;
import com.pack.model.CalculatorOutput;
import com.pack.model.CustomerDetails;
import com.pack.service.AccountService;

@RestController
public class HomeController {
	
    @Autowired
	private AccountService service;
    
    @PostMapping("/createAccount")
    public CustomerDetails saveCustomer(@RequestBody CustomerDetails details) {
    	
    	return service.saveData(details);
    }
    @GetMapping("/getDetails/{accountNo}")
    public CustomerDetails getCustomer(@PathVariable ("accountNo") Integer account) {
    	
    	return service.getData(account);
    }
    
    @PutMapping("/update/{accountNo}")
    public CustomerDetails updateCustomer(@RequestBody CustomerDetails details) {
    		return service.saveData(details);
    	
    }
    @DeleteMapping("/delete/{accountNo}")
    public String deleteCustomer(@PathVariable ("accountNo") Integer account) {
    	CustomerDetails cd=service.getData(account);
    	if(cd != null) {
    	service.deleteData(account);
    	return "Data Deleted Account of "+account;  
    	}
    	return "Provided account doesn't exist";
    }
    @PatchMapping("/activate/{accountNo}")
 public String activateCustomer(@PathVariable ("accountNo") Integer account) {
    	CustomerDetails cd=service.getData(account);
    	if(cd.getAccountStatus()=="active")return "Account already activated , Dont worry";
    	else {
    		cd.setAccountStatus("active");
    		service.saveData(cd);
    	return "account activation successfull "+account;}
    }
    @PatchMapping("/close/{accountNo}")
    public String deactivateCustomer(@PathVariable ("accountNo") Integer account) {
       	CustomerDetails cd=service.getData(account);
       	if(cd.getAccountStatus()=="closed")return "Account already Closed , Dont worry";
       	else {cd.setAccountStatus("closed");
       	service.saveData(cd);
       	return "account de-activation successfull "+account;}
       }
    @PostMapping("/calculator")
    public CalculatorOutput calculator(@RequestBody CalculatorInput in) {
    	return service.calculatorOut(in);
    }
    
}
