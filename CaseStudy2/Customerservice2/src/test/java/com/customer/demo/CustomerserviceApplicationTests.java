package com.customer.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.customer.demo.entities.Customer;
import com.customer.demo.repo.CustomerRepo;
import com.customer.demo.services.CustomerService;
import org.junit.jupiter.api.Order;
import org.mockito.*;

@SpringBootTest(classes= {CustomerserviceApplicationTests.class})
class CustomerserviceApplicationTests {

	@Mock         //Used for mocking the repository class
	CustomerRepo crepo;

	@InjectMocks  //Used for injecting/invoking the methods of service class
	CustomerService service;

	public List<Customer> f;

	@Test
	@Order(1)        //For executing this method first
	public void getCustomer() //test case for checking get all companies details 
	{
		List<Customer> f=new ArrayList<Customer>();
		f.add(new Customer(108, "Priyanka", "Priya123","Kolkata","priya8940.ch@gmail.com","priya89.roy"));
		
		//myusers.add(new Farmer(110, "Rajashi Paul", "rajashi.das2000@gmail.com","Female", "Patna","raj@2000"));
		//myusers.add(new Farmer(111, "Sumon Paul", "sumon.das2000@gmail.com","Male", "Gujrat","sumon@2000"));
		when(crepo.findAll()).thenReturn(f);
		assertEquals(1,service.servicegetallcustomers().size());        //Invoke the method from the service class
	}
	

}
