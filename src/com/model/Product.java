package com.model;

public class Product {
    private int productId;
    private String productName;
    private int available;
    private int mrp;
    private int quantityAvailable;
    private int quantityAdded;
	public int getQuantityAvailable() {
		return quantityAvailable;
	}
	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}
	public int getQuantityAdded() {
		return quantityAdded;
	}
	public void setQuantityAdded(int quantityAdded) {
		this.quantityAdded = quantityAdded;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	public int getMrp() {
		return mrp;
	}
	public void setMrp(int mrp) {
		this.mrp = mrp;
	}
    
}
