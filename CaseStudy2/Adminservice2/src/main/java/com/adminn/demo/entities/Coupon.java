package com.adminn.demo.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class Coupon {
	
	@Id
	int coupon_Id;	
	@Field
	String coupon_discount;
	@Field
	String coupon_code;
	@Field
	int product_id;
	@Field
	String coupon_product_name;
	@Field
	long product_price;
	@Field
	String coupon_set_name;
	public Coupon(int coupon_Id, String coupon_discount, String coupon_code, int product_id, String coupon_product_name,
			long product_price, String coupon_set_name) {
		super();
		this.coupon_Id = coupon_Id;
		this.coupon_discount = coupon_discount;
		this.coupon_code = coupon_code;
		this.product_id = product_id;
		this.coupon_product_name = coupon_product_name;
		this.product_price = product_price;
		this.coupon_set_name = coupon_set_name;
	}
	public Coupon() {
		
	}
	public int getCoupon_Id() {
		return coupon_Id;
	}
	public void setCoupon_Id(int coupon_Id) {
		this.coupon_Id = coupon_Id;
	}
	public String getCoupon_discount() {
		return coupon_discount;
	}
	public void setCoupon_discount(String coupon_discount) {
		this.coupon_discount = coupon_discount;
	}
	public String getCoupon_code() {
		return coupon_code;
	}
	public void setCoupon_code(String coupon_code) {
		this.coupon_code = coupon_code;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getCoupon_product_name() {
		return coupon_product_name;
	}
	public void setCoupon_product_name(String coupon_product_name) {
		this.coupon_product_name = coupon_product_name;
	}
	public long getProduct_price() {
		return product_price;
	}
	public void setProduct_price(long product_price) {
		this.product_price = product_price;
	}
	public String getCoupon_set_name() {
		return coupon_set_name;
	}
	public void setCoupon_set_name(String coupon_set_name) {
		this.coupon_set_name = coupon_set_name;
	}
	@Override
	public String toString() {
		return "Coupon [coupon_Id=" + coupon_Id + ", coupon_discount=" + coupon_discount + ", coupon_code="
				+ coupon_code + ", product_id=" + product_id + ", coupon_product_name=" + coupon_product_name
				+ ", product_price=" + product_price + ", coupon_set_name=" + coupon_set_name + "]";
	}
	
	
	
	
}
