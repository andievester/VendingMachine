package com.techelevator;

public class Gum extends Product {

	public Gum(String productName, Double productPrice) {
		super(productName, productPrice);
	}

	public String getSound() {
		return "Chew Chew, Yum!";
	}
}
