package com.techelevator;

import java.awt.PageAttributes.OriginType;
import java.math.BigDecimal;
import java.util.Scanner;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };
	private static final String FEED_THE_MACHINE_MONEY = "FEED MONEY";
	private static final String SELECT_YOUR_ITEM = "Select Product";
	private static final String FINISH_TRANSACTION = "Finish transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { FEED_THE_MACHINE_MONEY, SELECT_YOUR_ITEM,
			FINISH_TRANSACTION };
	private static VendingMachine vm = null;
	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				System.out.println(vm.display());
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				purchaseMenu();
			}
		}

// if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
// System.out.println(vm.display());
// System.out.println(vm.purchase(vendingChoice));

	}

	public void purchaseMenu() {
		boolean finished = false;
		System.out.println("Current balance is: " + "0.00");
		while (!finished) {
			String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

			if (choice.equals(FINISH_TRANSACTION)) {
				finished = true;
				System.out.println(vm.giveChange(vm.getBalance()));
				
			} else if (choice.equals(SELECT_YOUR_ITEM))
				if (vm.getBalance().equals(0)) {
					System.out.println("Insert more money!!");

				} else if (!(vm.getBalance().equals(0))) {
					System.out.println("Input your selection!");
					Scanner selection = new Scanner(System.in);
					String vendingChoice = selection.nextLine();
					System.out.println(vm.purchase(vendingChoice));

				}
			if (choice.equals(FEED_THE_MACHINE_MONEY)) {
				System.out.println("Please enter money :");
				Scanner amountEntered = new Scanner(System.in);
				String insertedMoney = amountEntered.nextLine();
				int moneyInt = Integer.parseInt(insertedMoney);
				vm.feedMoney(moneyInt);
				System.out.println("Current balance is: " + vm.getBalance());
				

			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		vm = new VendingMachine();
		cli.run();
	}
}
