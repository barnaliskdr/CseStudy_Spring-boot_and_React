package com.rabbit.demo.entities;

public class Purchase {

	private String purchase_id;
	private String category;
	private int price;
	public Purchase() {
		
	}
	public Purchase(String order_id, int price,String Category,String purchase_id) {
		super();
		this.purchase_id = order_id;
		this.price = price;
		this.purchase_id = purchase_id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPurchase_id() {
		return purchase_id;
	}
	public void setPurchase_id(String order_id) {
		this.purchase_id = order_id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Purchase [purchase_id=" + purchase_id + ", category=" + category + ", price=" + price + "]";
	}
	
}
