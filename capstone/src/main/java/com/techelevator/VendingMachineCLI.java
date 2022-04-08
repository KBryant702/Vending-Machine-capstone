package com.techelevator;

import com.techelevator.view.Inventory;
import com.techelevator.view.Menu;

import java.util.Scanner;


public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};
	private static final String CURRENT_MONEY_DISPLAY_TEXT = "Current Money Provided: $";

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

	private Menu menu;
	private Inventory inventory = new Inventory();

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		inventory.populateInventory();
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				inventory.displayInventory();
				// display vending machine items
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				double balance = 0.0;
				String itemPurchase = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS, CURRENT_MONEY_DISPLAY_TEXT);
				if (itemPurchase.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {


				} else if (itemPurchase.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
					inventory.displayInventory();
					String slot = menu.getStringFromUser("Enter the slot to vend: ").toUpperCase();
					//if inventory list contains product code provided, then it will decrease stock by 1,
					// update balance to remove price of item. then print item name cost,money remaining and item message.
					//return to purchase menu when complete
				} else if (itemPurchase.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {

					// do purchase
				} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
					System.out.println("Thank you for your purchase");
					break;
				}
			}
		}
	}

			public static void main (String[]args){
				Menu menu = new Menu(System.in, System.out);
				VendingMachineCLI cli = new VendingMachineCLI(menu);

				cli.run();
			}
	}

