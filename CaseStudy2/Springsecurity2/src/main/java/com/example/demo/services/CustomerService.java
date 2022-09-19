package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.models.Customer;
import com.example.demo.repositories.CustomersecurityRepository;



public class CustomerService {
	
	@Autowired
	public CustomersecurityRepository custrepo;
	
	public List<Customer> servicegetallcustomers() {
		return custrepo.findAll();
		}
	
}
