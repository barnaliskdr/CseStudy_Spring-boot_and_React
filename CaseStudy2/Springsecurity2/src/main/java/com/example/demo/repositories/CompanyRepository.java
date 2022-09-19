package com.example.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.models.Company;

@Repository
public interface CompanyRepository extends MongoRepository<Company,Integer>{
	

}
