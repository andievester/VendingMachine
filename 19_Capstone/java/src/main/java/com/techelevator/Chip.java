package com.techelevator;

public class Chip extends Product {

	public Chip(String productName, Double productPrice) {
		super(productName, productPrice);
	}

	public String getSound() {
		return "Crunch Crunch, Yum!";
	}
}
