package com.adminn.demo.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Customer {
    @Id
	private int customer_id;
	private String customer_name;
	@Indexed(unique =true)
	private String username;
	private String cust_location;
	@Indexed(unique =true)
	private String customer_email;
	private String cust_password;
	public Customer() {
	}
	public Customer(int customer_id, String customer_name, String username,String cust_location, String customer_email,
			String cust_password) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.username = username;
		this.customer_email = customer_email;
		this.cust_password = cust_password;
		this.cust_location = cust_location;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCustomer_email() {
		return customer_email;
	}
	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}
	public String getCust_password() {
		return cust_password;
	}
	public void setCust_password(String cust_password) {
		this.cust_password = cust_password;
	}
	
	public String getCust_location() {
		return cust_location;
	}
	public void setCust_location(String cust_location) {
		this.cust_location = cust_location;
	}
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_name=" + customer_name + ", username=" + username
				+ ", customer_email=" + customer_email + ", cust_password=" + cust_password + "]";
	}	
}