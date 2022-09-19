package com.adminn.demo.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.adminn.demo.entities.Customer;

import org.springframework.data.mongodb.repository.Query;


@Repository
public interface CustomerRepo extends MongoRepository<Customer,String>{

	com.adminn.demo.entities.Customer save(Customer com);

	
	@Query("{'customer_email' : ?0}")
	//List<Book> findPositionalParameters(String author, String category);
	Optional<Customer> findByEmail(String customer_email);
		



}
	
