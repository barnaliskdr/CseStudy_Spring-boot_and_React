package com.example.demo.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.demo.models.Company;


@Service
public class AdminService {
	
	
	@Autowired
	public RestTemplate restTemplate;
	
	public	List<Company> servicegetAllCoupondetails()
	{
		
		ResponseEntity<Company[]> companyResponse =  restTemplate.getForEntity("http://localhost:8086/mapcontroller/getAlldetails",Company[].class);
		Company[] company = companyResponse.getBody();
		return  Arrays.asList(company);
	}
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
	
}
