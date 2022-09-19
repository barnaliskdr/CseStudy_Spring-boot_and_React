package com.example.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Customer;


@Repository
public interface AdminserviceRepository extends  MongoRepository<Customer,Integer>{
	

}
