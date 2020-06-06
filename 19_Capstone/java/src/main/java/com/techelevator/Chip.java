package com.techelevator;

import java.math.BigDecimal;

public class Chip extends Product {

	public Chip(String productName, BigDecimal productPrice) {
		super(productName, productPrice);
	}

	public String getSound() {
		return "Crunch Crunch, Yum!";
	}
}
