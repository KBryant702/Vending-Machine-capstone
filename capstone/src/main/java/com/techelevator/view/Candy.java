package com.techelevator.view;

import java.math.BigDecimal;

public class Candy extends VendingMachineItem{
    private final static String purchaseMessage = "Munch Much, Yum!";

    public Candy(String slotIdentifier, Integer stock, String purchaseMessage, BigDecimal price, String name) {
        super(slotIdentifier, stock, purchaseMessage, price, name);
    }
    public String getPurchaseMessage(){
        return purchaseMessage;
    }
}
