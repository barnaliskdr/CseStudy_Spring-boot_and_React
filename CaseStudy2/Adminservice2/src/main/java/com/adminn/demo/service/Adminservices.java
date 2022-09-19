package com.adminn.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.adminn.demo.entities.Company;
import com.adminn.demo.entities.Customer;
import com.adminn.demo.repositories.Adminrepository;

public class Adminservices {
	
	
	@Autowired 
	public Adminrepository adminrepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
	
	
	public	List<Customer> servicegetAllCustomers()
	{
		ResponseEntity<Customer[]> custresponse = 
			
		restTemplate.getForEntity("http://localhost:8084/customer/Allcustdetails",Customer[].class);
		Customer[] custr = custresponse.getBody();
		
		return Arrays.asList(custr);
	}
	
	
	public	List<Company> servicegetAllCoupondetails()
	{
		
		ResponseEntity<Company[]> companyResponse =  restTemplate.getForEntity("http://localhost:8086/mapcontroller/getAlldetails",Company[].class);
		Company[] company = companyResponse.getBody();
		return  Arrays.asList(company);
	}
}
