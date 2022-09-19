package com.company.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.demo.entities.Company;
import com.company.demo.service.Companyservices;


@RestController
@RequestMapping("/mapcontroller")
//@CrossOrigin("*")
public class Companycontroller {
	
	
	@Autowired
	public Companyservices companyservice;
	
	@Autowired
	private RabbitTemplate template;
	
	@Bean
	public Companyservices companyservice()
	{
		return new Companyservices();
	}
	
	@PostMapping("/create") 
	public ResponseEntity<?> createcoupons(@RequestBody Company com)
	{
			return companyservice.servicecreatecoupons(com);
	}
	
	@DeleteMapping("deleteProductsbyId/{id}")
	public ResponseEntity<String> deleteCouponsBycompanyId(@PathVariable("id") String company_id){
		return companyservice.servicedeleteCouponsBycompanyId(company_id);
	}
	
	@GetMapping("/getAlldetails")
	public List<Company> gettotalorders() {
		return companyservice.servicegettotalorders();
		}
	
	@GetMapping("/getcoupondetailsbyId/{id}")
	public Company getdetailsbyId(@PathVariable("id") String company_id) {
		return companyservice.servicegetdetailsbyId(company_id);
		}
	
	
	@PutMapping("/updateById/{company_id}")
	public ResponseEntity<?> updateById(@RequestBody Company company,@PathVariable("company_id") String company_id){
	
		return companyservice.serviceupdateById(company, company_id);
	}
	
	@GetMapping("/getByCompanyName/{company_name}")
	public List<?> getCouponByCompanyName(@PathVariable("company_name") String company_name) {
		
					return companyservice.servicegetCouponByCompanyName(company_name);}
	              /* List<Company>  companyresponse = 
	               if(!companyresponse.isEmpty())
	               {
	            	   return companyresponse;
	               }
	               else
	               {
	            	   String response = "Record_Not_Found";
	            	   List<?> finalresponse = Arrays.asList(response);
	            	   return finalresponse;
	               }
	}*/
	/*@PutMapping("updatebyid/{id}")
	public ResponseEntity<String> updateById(@PathVariable int id) {
		return new ResponseEntity<String>(companyrepos.updateById(id)+" record(s) updated.", HttpStatus.OK);
	}*/
	
	@GetMapping("/productcategory/{product_category}")
	public List<?> getCouponByProductCategory(@PathVariable("product_category") String product_category) {
		
		return companyservice.servicegetCouponByProductCategory(product_category);}
		/* List<Company>  product_category_response = companyrepos.findByProductCategory(product_category);
		 if(!product_category_response.isEmpty())
         {
      	   return product_category_response;
         }
		 else {
			 String category_response = "Record_Not_Found";
			 List<?> final_category_response = Arrays.asList(category_response);
      	   	return final_category_response;
		 }
		
	}*/
	@PostMapping("/publishcoupon")
	public String bookpurchase(@RequestBody com.company.demo.entities.Purchase purchase)
	{
		 purchase.setPurchase_id(UUID.randomUUID().toString());
		 com.company.demo.entities.PurchaseStatus status = new com.company.demo.entities.PurchaseStatus(purchase, "succesful", "purchase done successfully");
		 template.convertAndSend(com.company.demo.msgconfig.MessagingConfig.exchange,com.company.demo.msgconfig.MessagingConfig.routing_key,status);
		 return "Successfully coupon published";
	}
	
}
