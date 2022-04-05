package com.techelevator.view;

import java.math.BigDecimal;

public class Gum extends VendingMachineItem{
    //private final static String type = "Candy";
    private final static String purchaseMessage = "Chew Chew, Yum!";

    public Gum(String slotIdentifier, Integer stock, String purchaseMessage, BigDecimal price, String name) {
        super(slotIdentifier, stock, purchaseMessage, price, name);
    }
    public String getPurchaseMessage(){
        return purchaseMessage;
    }
}
