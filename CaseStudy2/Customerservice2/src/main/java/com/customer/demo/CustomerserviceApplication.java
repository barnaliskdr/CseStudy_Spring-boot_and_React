package com.customer.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.customer.demo.entities.Customer;
import com.customer.demo.repo.CustomerRepo;



@SpringBootApplication
@EnableEurekaClient
public class CustomerserviceApplication  {
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerserviceApplication.class, args);
	}
	

}