package com.techelevator;

import java.util.Scanner;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };
	private static final String FEED_THE_MACHINE_MONEY = "Feed money";
	private static final String SELECT_YOUR_OPTION = "Please make a selection";
	private static final String FINISH_TRANSACTION = "Finish transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { FEED_THE_MACHINE_MONEY, SELECT_YOUR_OPTION,
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
				System.out.println(vm.display());
				System.out.println("Input your selection:");
				Scanner selectionChoice = new Scanner(System.in);
				String guestChoice = selectionChoice.nextLine();
			System.out.println(vm.purchase(choice));
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
