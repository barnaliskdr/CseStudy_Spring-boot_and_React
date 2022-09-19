package com.customer.demo.entities;

import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Company {
	
	@Id
	String company_id;
	@Field
	String company_name;
	@Field
	private String location;
	@Indexed(unique =true)
	private String company_email;
	private String company_pswd;
	public String product_category;
	@Field
	public Coupon coupon;
	public Company() {
		
		// TODO Auto-generated constructor stub
	}
	
	public Company(String company_id, String company_name, String location, String company_email, String company_pswd,
			String product_category, Coupon coupon) {
		super();
		this.company_id = company_id;
		this.company_name = company_name;
		this.location = location;
		this.company_email = company_email;
		this.company_pswd = company_pswd;
		this.product_category = product_category;
		this.coupon = coupon;
	}

	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCompany_email() {
		return company_email;
	}
	public void setCompany_email(String company_email) {
		this.company_email = company_email;
	}
	public String getCompany_pswd() {
		return company_pswd;
	}
	public void setCompany_pswd(String company_pswd) {
		this.company_pswd = company_pswd;
	}
	public String getProduct_category() {
		return product_category;
	}
	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}
	
	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	@Override
	public String toString() {
		return "Company [company_id=" + company_id + ", company_name=" + company_name + ", location=" + location
				+ ", company_email=" + company_email + ", company_pswd=" + company_pswd + ", product_category="
				+ product_category + ", coupon=" + coupon + "]";
	}
	
	
}
