package com.adminn.demo.entities;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

public class Adminentity {
	
	
	@Id
	private int id;
	@Indexed(unique =true)
	private String admin_email;
	private String password;
	public Adminentity() {
		
	}
	public Adminentity(int id, String admin_email, String password) {
		super();
		this.id = id;
		this.admin_email = admin_email;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdmin_email() {
		return admin_email;
	}
	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Adminentity [id=" + id + ", admin_email=" + admin_email + ", password=" + password + "]";
	}
	
}
