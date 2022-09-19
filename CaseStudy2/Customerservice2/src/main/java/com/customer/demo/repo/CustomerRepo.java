package com.customer.demo.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.customer.demo.entities.Customer;

import org.springframework.data.mongodb.repository.Query;

@Repository
public interface CustomerRepo extends MongoRepository<Customer,Integer>{

	Customer save(Customer com);
	
	@Query("{'customer_email' : ?0}")
	//List<Book> findPositionalParameters(String author, String category);
	Optional<Customer> findByEmail(String customer_email);
		
	@Query("{'customer_email' : ?0}")
	Customer findByEmailid(String customer_email);


}
	
