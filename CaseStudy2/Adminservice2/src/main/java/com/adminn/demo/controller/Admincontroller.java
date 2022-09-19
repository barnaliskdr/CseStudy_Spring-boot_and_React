package com.adminn.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.adminn.demo.entities.Company;
import com.adminn.demo.entities.Customer;
import com.adminn.demo.repositories.Adminrepository;
import com.adminn.demo.repositories.CustomerRepo;
import com.adminn.demo.service.Adminservices;


@RestController
@RequestMapping("/Admin")

public class Admincontroller {
	
	
	@Autowired 
	public Adminservices adminservice;
	
	@Bean
	public Adminservices adminservice()
	{
		return new Adminservices();
	}
	
	
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
	
	@Autowired
	public RestTemplate restTemplate;
	
	/*@GetMapping("/seecoupons")
	public	List<Company> getAllCoupondetails()
	{
		
		ResponseEntity<List<Company>> companyResponse =  restTemplate.exchange("http://localhost:8086/mapcontroller/getAlldetails",HttpMethod.GET, null, new ParameterizedTypeReference<List<Company>>() {});
		List<Company> company = companyResponse.getBody();
		return  company;
	}
	
	@GetMapping("/allcustomers")
	public	List<Customer> getAllCustomers()
	{
		
		ResponseEntity<List<Customer>> custresponse =  restTemplate.exchange("http://localhost:8084/customer/Allcustdetails",HttpMethod.GET, null, new ParameterizedTypeReference<List<Customer>>() {});
		List<Customer> custr = custresponse.getBody();
		return  custr;
	}*/
	
	@GetMapping("/allcustomers")
	public	List<Customer> getAllCustomers()
	{
		return adminservice.servicegetAllCustomers();
	}
		
	@PutMapping("/{customer_email}")
	public List<Customer> updatecustomerByEmail(@RequestBody Customer customer,@PathVariable("customer_email") String customer_email)
	{
		ResponseEntity<List<Customer>> custresponse = restTemplate.exchange("http://localhost:8084/customer/updateByEmail/"+customer_email,HttpMethod.PUT, null, new ParameterizedTypeReference<List<Customer>>() {});	
		List<Customer> custr = custresponse.getBody();
		
		return custr;
	}
	
	@GetMapping("/seecoupons")
	public	List<Company> getAllCoupondetails()
	{
		return  adminservice.servicegetAllCoupondetails();
	}
	
}
