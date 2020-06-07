package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class VendingMachine {

	Map<String, Product> stock = new TreeMap<>();
	private BigDecimal balance = new BigDecimal(0.00).setScale(2);
	LogWriter writer = new LogWriter();

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
		Product selectedProduct = stock.get(userSelection);
		if (!stock.containsKey(userSelection)) {
			result += ("Invalid Entry! Please make another selection!");

		} else if (selectedProduct.getQuantity() == 0) {
			result += " Sold out!";
		} else if (balance.compareTo(selectedProduct.getProductPrice()) <= 0) {
			result += "Insufficient funds!";
		} else if (stock.containsKey(userSelection)) {

			result = "You selected " + selectedProduct.getProductName() + " " + "$" + selectedProduct.getProductPrice()
					+ "\n";

			System.out.println(selectedProduct.getSound());
			if (balance.compareTo(selectedProduct.getProductPrice()) >= 0) {
				selectedProduct.setQuantity(selectedProduct.getQuantity() - 1);
				balance = balance.subtract(selectedProduct.getProductPrice());
				result += "Your balance is: $" + balance;
				String writerProduct = selectedProduct.getProductName();
				BigDecimal cost = selectedProduct.getProductPrice();
				writer.writer(writerProduct, cost.toString(), balance);
			}

		}
		return result;
	}

	public String feedMoney(double addMoney) {

		String transaction = "FEED MONEY:";
		String result = "Your balance is " + balance;
		if (addMoney == 1) {
			balance = balance.add(new BigDecimal(1.00));
			writer.writer(transaction, new BigDecimal(1.00).setScale(2).toString(), balance);
		} else if (addMoney == 5) {
			balance = balance.add(new BigDecimal(5.00));
			writer.writer(transaction, new BigDecimal(5.00).setScale(2).toString(), balance);
		} else if (addMoney == 20) {
			balance = balance.add(new BigDecimal(20.00));
			writer.writer(transaction, new BigDecimal(20.00).setScale(2).toString(), balance);
		} else if (addMoney == 10) {
			balance = balance.add(new BigDecimal(10.00));
			writer.writer(transaction, new BigDecimal(10.00).setScale(2).toString(), balance);
		} else if (addMoney == .10) {
			balance = balance.add(new BigDecimal(0.10));
			writer.writer(transaction, new BigDecimal(0.10).setScale(2).toString(), balance);
		} else if (addMoney == .25) {
			balance = balance.add(new BigDecimal(0.25));
			writer.writer(transaction, new BigDecimal(0.25).setScale(2).toString(), balance);
		} else if (addMoney == .05) {
			balance = balance.add(new BigDecimal(0.05));
			writer.writer(transaction, new BigDecimal(0.05).setScale(2).toString(), balance);
		}
		return result;

	}

	public BigDecimal getBalance() {
		return balance;

	}

	public String giveChange(BigDecimal change) {
		double balance1;
		int quarters1;
		int dime1;
		int nickels1;
		String result = "";
		balance1 = (balance.doubleValue() * 100);
		quarters1 = ((int) balance1 / 25);
		balance1 = balance1 - (quarters1 * 25);
		dime1 = ((int) balance1 / 10);
		balance1 = balance1 - (dime1 * 10);
		nickels1 = ((int) balance1 / 5);

		result = "Your change is " + quarters1 + " quarters and " + dime1 + " dimes and " + nickels1 + " nickels. ";
		return result;

	}
}