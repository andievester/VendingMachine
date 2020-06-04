package com.techelevator;

public class Drink extends Product {

	public Drink(String productName, Double productPrice) {
		super(productName, productPrice);
	}

	public String getSound() {
		return "Glug Glug, Yum!";
	}
}