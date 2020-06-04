package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class VendingMachine {
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
					}
					else if (type.equals("Candy")) {
						currentItem = new Candy(name, price);
					}
					else if (type.equals("Drink")) {
						currentItem = new Drink(name, price);
					}
					else if (type.equals("Gum")) {
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
					result += (location + " OUT OF STOCK! \n");
				} else {

					result += (location + " " + p.getProductName() + " " + p.getProductPrice() + "\n");
				}
			}
		}
		return result;

	}

	public String purchase(String userSelection) {
		String result = "";
		if(!vendingMachineStock.containsKey(userSelection)) {
			result += ("Invalid Entry! Please make another selection!");
		}

		if (vendingMachineStock.containsKey(userSelection)) {
			if (vendingMachineStock.get(userSelection) == null) {
				System.out.println("Sorry out of stock!");
		return result;
	}
 
}
		return result;
	}
}
