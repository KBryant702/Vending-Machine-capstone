package com.techelevator;


import com.techelevator.view.Menu;
import com.techelevator.view.VendingMachine;


public class VendingMachineCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};
    private static final String CURRENT_MONEY_DISPLAY_TEXT = "Current Money Provided: ";

    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};
    private static final String FILE_PATH = "vendingmachine.csv";

    private Menu menu;
    private VendingMachine vendingMachine;

    public VendingMachineCLI(Menu menu, VendingMachine vendingMachine) {
        this.menu = menu;
        this.vendingMachine = vendingMachine;
    }

    public void run() {
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                vendingMachine.displayInventory();

            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                while (true) {
                    //display purchase menu with current money balance
                    String itemPurchase = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS, CURRENT_MONEY_DISPLAY_TEXT + vendingMachine.getStrBalance());
                    if (itemPurchase.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
                        int feedAmount = menu.getMoneyFromUser();
                        vendingMachine.feedMoney(feedAmount);
                    } else if (itemPurchase.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
                        vendingMachine.displayInventory();
                        String slot = menu.getSlotFromUser();
                        vendingMachine.vend(slot);

                    } else if (itemPurchase.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
                        System.out.println();
                        System.out.println(vendingMachine.returnChange());
                        break;
                    }
                }
            } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                System.out.println("Thank you for your purchase");
                break;
            }
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachine vendingMachine = new VendingMachine(FILE_PATH);
        VendingMachineCLI cli = new VendingMachineCLI(menu, vendingMachine);

        cli.run();
    }
}

