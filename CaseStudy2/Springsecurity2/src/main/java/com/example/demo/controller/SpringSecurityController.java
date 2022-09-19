package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Company;
import com.example.demo.models.Customer;
import com.example.demo.services.AdminService;
import com.example.demo.services.CompanysecurityService;
import com.example.demo.services.CustomerService;


@RestController
@RequestMapping("/Security")
public class SpringSecurityController {
	
	@Autowired 
	public CustomerService custservice;
	@Autowired
	public AdminService adminservice;
	@Autowired
	public CompanysecurityService compservice;
	
	@Bean
	 public CustomerService custservice()
	 {
		 return new CustomerService();
	 }
	
	@Bean
	 public AdminService adminservice()
	 {
		 return new AdminService();
	 }
	
	@Bean
	 public CompanysecurityService compservice()
	 {
		 return new CompanysecurityService();
	 }
	
	
	@GetMapping("/customer/Allcustdetails")
	public List<Customer> gettotalcustomerdetails() {
		return custservice.servicegetallcustomers();
		}
	
	@GetMapping("/admin/seecoupons")
	public	List<Company> getAllCoupondetails()
	{
		return  adminservice.servicegetAllCoupondetails();
	}
	
	@GetMapping("/company/getAlldetails")
	public List<Company> gettotalorders() {
		return compservice.servicegettotalorders();
		}
}
