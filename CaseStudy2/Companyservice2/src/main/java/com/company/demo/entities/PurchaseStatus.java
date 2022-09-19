package com.company.demo.entities;

import lombok.Data;

@Data
public class PurchaseStatus {
	
	private Purchase purchase;
	private String status;
	private String message;
	public PurchaseStatus() {
		
	}
	 
	public PurchaseStatus(Purchase purchase, String status, String message) {
		super();
		this.purchase = purchase;
		this.status = status;
		this.message = message;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "PurchaseStatus [purchase=" + purchase + ", status=" + status + ", message=" + message + "]";
	}
	
	
}
