package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class VendingMachine {
	
	
	double balance = 0;
	Map<String, Product> vendingMachineStock = new TreeMap<>();

	public VendingMachine() {
		File inventoryFile = new File("VendingMachine.txt");

		try (Scanner stockImporter = new Scanner(inventoryFile)) {
			while (stockImporter.hasNextLine()) {
				String line = stockImporter.nextLine();
				if (!line.isEmpty()) {
					String[] stockItemNames = line.split("\\|");
					String name = stockItemNames[1];
					Double price = Double.parseDouble(stockItemNames[2]);
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

					vendingMachineStock.put(location, currentItem);

				}
			}
		}

		catch (FileNotFoundException e) {
			System.out.println("No file found!!!");
			e.printStackTrace();
			System.exit(1);
		}
	}

	public String display() {
		String result = "";

		for (String location : vendingMachineStock.keySet()) {
			Product p = vendingMachineStock.get(location);
			if (p != null) {

				if (p.getQuantity() == 0) {
					result += (location + " SOLD OUT! \n");
				} else {

					result += (location + " " + p.getProductName() + " " + p.getProductPrice() + "\n");
				}
			}
		}
		return result;
	}
	
	
	
	public void feedMoney(String string) {
	String transaction = "FEED MONEY: ";
	double newMoney = 0;
    feedMoney(Double.toString(balance) + Double.toString(newMoney));
	
	
			
			
		}
	
	

	public String purchase(String userChoice) {
		String result = "";
		if (!vendingMachineStock.containsKey(userChoice)) {
			result += ("Invalid Entry! Please make another selection!");
		}

		if (vendingMachineStock.containsKey(userChoice)) {
			Product selectedProduct = vendingMachineStock.get(userChoice);
			result = "You selected " + selectedProduct.getProductName() + " $"+selectedProduct.getProductPrice();

		}

		return result;
	}
}

