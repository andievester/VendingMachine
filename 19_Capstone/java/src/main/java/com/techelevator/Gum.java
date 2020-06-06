package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Product {

	public Gum(String productName, BigDecimal productPrice) {
		super(productName, productPrice);
	}

	public String getSound() {
		return "Chew Chew, Yum!";
	}
}
