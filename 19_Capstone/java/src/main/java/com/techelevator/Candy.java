package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Product {

	public Candy(String productName, BigDecimal productPrice) {
		super(productName, productPrice);
	}

	public String getSound() {
		return "Munch Munch, Yum!";
	}
}
