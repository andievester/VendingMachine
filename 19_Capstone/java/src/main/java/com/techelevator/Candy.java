package com.techelevator;

public class Candy extends Product {

	public Candy(String productName, Double productPrice) {
		super(productName, productPrice);
	}

	public String getSound() {
		return "Munch Munch, Yum!";
	}
}
