package com.company.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.company.demo.entities.Company;
import com.company.demo.entities.Coupon;


@Repository
public interface CompanyRepos extends MongoRepository<Company,String>{

	Company save(Company com);

	@Query("{company_name:?0}")
	 List<Company> findByName(String company_name);

	@Query("{product_category:?0}")
	List<Company> findByProductCategory(String product_category);

}
