package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class VendingMachine {
	Map<String, Product> stock = new TreeMap<>();
	private BigDecimal balance = new BigDecimal(0.00).setScale(2);

	public VendingMachine() {
		File stockFile = new File("VendingMachine.txt");

		try (Scanner stockImporter = new Scanner(stockFile)) {
			while (stockImporter.hasNextLine()) {
				String line = stockImporter.nextLine();
				if (!line.isEmpty()) {
					String[] stockItemNames = line.split("\\|");
					String name = stockItemNames[1];
					BigDecimal price = new BigDecimal(stockItemNames[2]);
					String location = stockItemNames[0];
					String type = stockItemNames[3];
					Product currentItem = null;

					if (type.equals("Chip")) {
						currentItem = new Chip(name, price);
					} else if (type.equals("Candy")) {
						currentItem = new Candy(name, price);
					} else if (type.equals("Drink")) {
						currentItem = new Drink(name, price);
					} else if (type.equals("Gum")) {
						currentItem = new Gum(name, price);
					}

					stock.put(location, currentItem);

				}
			}
		}

		catch (FileNotFoundException e) {
			System.out.println("No file present");
			e.printStackTrace();
			System.exit(1);
		}

	}

	public String display() {
		String result = "";
		for (String location : stock.keySet()) {
			Product p = stock.get(location);
			if (p != null) {
				if (p.getQuantity() == 0) {
					result += location + "Out of Stock\n";
				} else {

					result += (location + " " + p.getProductName() + " " + p.getProductPrice() + "\n");
				}
			}
		}
		return result;
	}

	public String purchase(String userSelection) {
		String result = "";
		if (!stock.containsKey(userSelection)) {
			result += ("Invalid Entry! Please make another selection!");

		}
		if (stock.containsKey(userSelection)) {
			Product selectedProduct = stock.get(userSelection);
			result = "You selected " + selectedProduct.getProductName() + " " + "$" + selectedProduct.getProductPrice()
					+ "\n";
			System.out.println(selectedProduct.getSound());
			if (balance.compareTo(selectedProduct.getProductPrice()) >= 0) {
				selectedProduct.setQuantity(selectedProduct.getQuantity() - 1);
				balance = balance.subtract(selectedProduct.getProductPrice());
				result += "Your balance is: $" + balance;
			}
			if (selectedProduct.getQuantity() == 0) {
				result += " Sold out!";
			} else if (balance.equals(0.0)) {
				result = "Insufficient funds!";
			}

			return result;
		}
		return result;
	}

	public String feedMoney(double addMoney) {

		String transaction = "FEED MONEY:";
		String result = "Your balance is " + balance;
		if (addMoney == 1) {
			balance = balance.add(new BigDecimal(1.00));
		} else if (addMoney == 5) {
			balance = balance.add(new BigDecimal(5.00));
		} else if (addMoney == 10) {
			balance = balance.add(new BigDecimal(10.00));
		} else if (addMoney == 20) {
			balance = balance.add(new BigDecimal(20.00));
		} else if (addMoney == .10) {
			balance = balance.add(new BigDecimal(0.10));
		} else if (addMoney == .25) {
			balance = balance.add(new BigDecimal(0.25));
		} else if (addMoney == .05) {
			balance = balance.add(new BigDecimal(0.05));
		}
		return result;

	}

	public String giveChange(BigDecimal balance) {
		String result = "";
		double balance1;
		int quarters1;
		int dime1;
		int nickels;
		int factor = 100;
		BigDecimal factorToBD = new BigDecimal(BigInteger.ZERO, 100);
		BigDecimal balance11 = balance.multiply(new BigDecimal(factor));
		int quarterFactor = 25;
		BigDecimal quarterToBD = new BigDecimal(BigInteger.ZERO, 25);
		BigDecimal quarters11 = balance11.divide(new BigDecimal(quarterFactor));
		BigDecimal balance2 = balance11.subtract(quarters11.multiply(new BigDecimal(quarterFactor)));
		int dimeFactor = 10;
		BigDecimal dimeToBD = new BigDecimal(BigInteger.ZERO, 10);
		BigDecimal dime11 = balance11.divide(new BigDecimal(dimeFactor));
		BigDecimal balance3 = balance2.subtract(dime11.multiply(new BigDecimal(dimeFactor)));
		int nickelFactor = 5;
		BigDecimal nickelToBD = new BigDecimal(BigInteger.ZERO, 5);
		BigDecimal nickel1 = balance3.divide(new BigDecimal(nickelFactor));
		result = "Your change is " + quarters11 + " quarters and " + dime11 + " dimes and " + nickel1 + " nickels.";
		return result;
	}

	public BigDecimal getBalance() {
		return balance;

	}

}
