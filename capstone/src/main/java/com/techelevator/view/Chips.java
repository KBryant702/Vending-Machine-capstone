package com.techelevator.view;

import java.math.BigDecimal;

public class Chips extends VendingMachineItem{
    //private final static String type = "Candy";
    private final static String purchaseMessage = "Crunch Crunch, Yum!";

    public Chips(String slotIdentifier, Integer stock, String purchaseMessage, BigDecimal price, String name) {
        super(slotIdentifier, stock, purchaseMessage, price, name);
    }
    public String getPurchaseMessage(){
        return purchaseMessage;
    }
}
