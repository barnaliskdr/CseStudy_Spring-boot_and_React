package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entities.Customer;



public class SpringJwtController {
	
	@Autowired 
	public CustomerService custservice;
	
	@Bean
	 public CustomerService custservice()
	 {
		 return new CustomerService();
	 }
	
	@GetMapping("/customer/Allcustdetails")
	public List<Customer> gettotalcustomerdetails() {
		return custservice.servicegetallcustomers();
		}
}
