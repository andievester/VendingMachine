package com.techelevator;

public abstract class Product {

	private String productName;
	private double productPrice;
	private int quantity;

	
	private static int STARTING_QUANTITY = 5;
	public Product(String productName, Double productPrice) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.quantity = STARTING_QUANTITY;
	}

	public abstract String getSound();

	public String getProductName() {
		return productName;
	}
	public int getQuantity() {
		return quantity;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

}
