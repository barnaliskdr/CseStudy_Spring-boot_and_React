package com.example.demo.repositories;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.models.Customer;



public interface CustomersecurityRepository extends MongoRepository<Customer,Integer>{

	List<Customer> findAll();
		
	
	
	
}
