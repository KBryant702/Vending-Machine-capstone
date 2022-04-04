package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;

public class PurchaseMenu extends Menu{

    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

    private static final String CURRENT_MONEY_DISPLAY_TEXT = "Current Money Provided: $";

    public PurchaseMenu(InputStream input, OutputStream output) {
        super(input, output);
    }

}
