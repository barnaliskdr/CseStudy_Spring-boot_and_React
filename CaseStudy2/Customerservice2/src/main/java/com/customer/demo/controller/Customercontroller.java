package com.customer.demo.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;

import com.customer.demo.entities.Company;
import com.customer.demo.entities.Customer;
import com.customer.demo.repo.CustomerRepo;
import com.customer.demo.services.CustomerService;


@RestController
@RequestMapping("/customer")
public class Customercontroller {
	
	@Autowired 
	public CustomerService custservice;
	
	@Autowired
	private CustomerRepo custrepo;
	
	 Company company = new Company();
	
	 @Bean
	 public CustomerService custservice()
	 {
		 return new CustomerService();
	 }
	 
	 
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
	
	@Autowired
	public RestTemplate restTemplate;
	
	@PostMapping("/customercreate") 
	public ResponseEntity<?> createCustomer(@RequestBody Customer cust)
	{
		return custservice.servicecreatecustomer(cust);
	}
	
	@GetMapping("/Allcustdetails")
	public List<Customer> gettotalcustomerdetails() {
		return custservice.servicegetallcustomers();
		}
	
	@PutMapping("/updateByEmail/{customer_email}")
	public ResponseEntity<?> updateById(@RequestBody Customer customer,@PathVariable("customer_email") String customer_email){
	
		return custservice.serviceupdateById(customer, customer_email);
      }
	
	
	
	@GetMapping("/find")
	public	List<Company> getAlldetails()
	{
		
		return  custservice.servicegetAllcoupondetails();
	}
	
	@GetMapping("/{company_name}")
	public	List<Company> getCouponByCompanyName(@PathVariable("company_name") String company_name)
	{
		
		return custservice.servicegetCouponByCompanyName(company_name);
	}
	
	@GetMapping("/category/{product_category}")
	public	List<Company> getCouponByProductCategory(@PathVariable("product_category") String product_category)
	{
		return custservice.servicegetCouponByProductCategory(product_category);
	}
	
	/*ResponseEntity<List<Rate>> rateResponse =
	        restTemplate.exchange("https://bitpay.com/api/rates",
	                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Rate>>() {
	            });
	List<Rate> rates = rateResponse.getBody();*/
	
	
	/*@GetMapping("/getbycust")
	public List<Customer> getComapny(){
		Company comp = webclient.build().get().uri("localhost:8086/mapcontroller/getAlldetails")
		.retrieve()
		.bodyToMono(Company.class)
		.block();
		return  custrepo.findAll();
		
	}*/
	
	@GetMapping("/pay")
	public	void purchasecoupon()//@PathVariable("customer_Id")int customer_Id)
	{
		custservice.servicepurchasecoupon();//(customer_Id);
	}
	
	@RabbitListener(queues = com.customer.demo.MessagingConfig.MessagingConfig.queue)
	public void ConsumeMessageFromQueue(com.customer.demo.entities.PurchaseStatus purchasestatus)
	{
		System.out.println("Received message from company: "+purchasestatus);
	}
}
