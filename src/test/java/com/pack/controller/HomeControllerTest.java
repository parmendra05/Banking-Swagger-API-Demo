package com.pack.controller;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.pack.model.CustomerDetails;
import com.pack.service.AccountService;

@SpringBootTest
class HomeControllerTest {
	
	@InjectMocks
	private HomeController controller;
	@Mock
	private AccountService service;

	@Test
	void colculatorTest() {
		
	}
	
	@Test
	void saveCustomerTest() { 
		CustomerDetails details=new CustomerDetails
				(12345, "param", "bangalore", 49000, "active");
		when(service.saveData(details)).thenReturn(details);
		CustomerDetails newDetails=controller.saveCustomer(details);
		verify(service).saveData(details);
		assertNotNull(newDetails);
		assertEquals("param", details.getCustomerName());
		
		
		
	}

}
