package com.company.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.company.demo.entities.Company;
import com.company.demo.entities.Coupon;
import com.company.demo.repository.CompanyRepos;
import com.company.demo.service.Companyservices;

@SpringBootTest
class CompanyserviceApplicationTests {

	@Mock         //Used for mocking the repository class
	CompanyRepos crepo;

	@InjectMocks  //Used for injecting/invoking the methods of service class
	Companyservices service;

	public List<Company> f;

	/*@Test
	@Order(1)      
	public void getCompany() //test case for checking get all companies details 
	{
		List<Company> f=new ArrayList<Company>();
		f.add(new Company(185, "Flpkrt", "Kolkata","flpkrtconnect234@gmail.com","flpkrt9035","Electronics",(new Coupon(1398,"56","Flpkrt1398",3980,"Tab",33000,"Monsoon sale"))));
		
		when(crepo.findAll()).thenReturn(f);
		assertEquals(1,service.servicegettotalorders().size());        //Invoke the method from the service class
	}
	
	@Test
	@Order(1)        //For executing this method first
	public void saveCompany() 
	{
		Company c=new Company(155, "Netmeds", "Delhi","netmedscontact@gmail.com","netmeds195","Medicine",(new Coupon(138,"26","Netmeds138",4380,"vitamin-c",500,"Monsoon sale")));
		
		when(crepo.save(c)).thenReturn(c);
		assertEquals(c,service.servicecreatecoupons(c));        //Invoke the method from the service class
	}

	*/
	
}
