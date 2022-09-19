package com.customer.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.customer.demo.entities.Company;
import com.customer.demo.entities.Customer;
import com.customer.demo.repo.CustomerRepo;

public class CustomerService {
	@Autowired
	private CustomerRepo custrepo;
	
	Company company = new Company();
	
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
	
	@Autowired
	public RestTemplate restTemplate;
	
	public ResponseEntity<?> servicecreatecustomer(Customer cust)
	{
		try {
			Customer savedcust = this.custrepo.save(cust);
			
			return new ResponseEntity<>("Added successfully",HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public List<Customer> servicegetallcustomers() {
		return custrepo.findAll();
		}
	
	
	public ResponseEntity<?> serviceupdateById(Customer customer,String customer_email){
		Optional<Customer> cust= custrepo.findByEmail(customer_email);
		try {
		if(cust.isPresent()) {
			customer.setCustomer_email(customer.getCustomer_email());
	        custrepo.save(customer);
	        //return company;
	        return new ResponseEntity<>("Updated successfully",HttpStatus.OK);
		
			} 
			else {
				return new ResponseEntity<>("Record Not found",HttpStatus.OK);
			}
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public	List<Company> servicegetCouponByCompanyName(String company_name)
	{
		
		ResponseEntity<List<Company>> companyResponse =  restTemplate.exchange("http://localhost:8086/mapcontroller/getByCompanyName/"+company_name,HttpMethod.GET, null, new ParameterizedTypeReference<List<Company>>() {});	
		
		List<Company> company = companyResponse.getBody();
		return  company;
	}
	
	public	List<Company> servicegetAllcoupondetails()
	{
		ResponseEntity<List<Company>> companyResponse =  restTemplate.exchange("http://localhost:8086/mapcontroller/getAlldetails",HttpMethod.GET, null, new ParameterizedTypeReference<List<Company>>() {});
		
		List<Company> company = companyResponse.getBody();
		return  company;
	}
	
	public	List<Company> servicegetCouponByProductCategory(String product_category)
	{
		
		ResponseEntity<List<Company>> companyResponse =  restTemplate.exchange("http://localhost:8086/mapcontroller/productcategory/"+product_category,HttpMethod.GET, null, new ParameterizedTypeReference<List<Company>>() {});
		List<Company> company = companyResponse.getBody();
		return  company;
	}

	
	public void servicepurchasecoupon() {
		///Optional<Customer> cust= custrepo.findById(customer_Id);
		// TODO Auto-generated method stub
		//ResponseEntity<List<Company>> 
		ResponseEntity<String> companyResponse =  restTemplate.exchange("http://localhost:9090/submitPaymentDetail",HttpMethod.GET, null, new ParameterizedTypeReference<String>() {});
	}
}
