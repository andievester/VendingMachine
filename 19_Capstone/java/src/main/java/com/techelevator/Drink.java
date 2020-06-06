package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Product {

	public Drink(String productName, BigDecimal productPrice) {
		super(productName, productPrice);
	}

	public String getSound() {
		return "Glug Glug, Yum!";
	}
}