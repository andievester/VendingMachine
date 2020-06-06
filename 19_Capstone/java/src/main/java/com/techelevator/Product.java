package com.techelevator;

import java.math.BigDecimal;

public abstract class Product {
	private String productName;
	private BigDecimal productPrice;
	private int quantity;

	private static int STARTING_QUANTITY = 5;

	public Product(String productName, BigDecimal productPrice) {
		this.setProductName(productName);
		this.setProductPrice(productPrice);
		this.setQuantity(STARTING_QUANTITY);
	}

	public abstract String getSound();

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
