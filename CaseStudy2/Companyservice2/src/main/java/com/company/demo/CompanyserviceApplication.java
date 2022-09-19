package com.company.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.client.RestTemplate;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableEurekaClient
//@EnableSwagger2
public class CompanyserviceApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(CompanyserviceApplication.class, args);
	}

}
