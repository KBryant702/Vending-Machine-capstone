package com.techelevator.view;

import java.math.BigDecimal;

public abstract class VendingMachineItem {
    private String type;
    private String slotIdentifier;
    private Integer stock = 5;
    private String purchaseMessage;
    private BigDecimal price;
    private String name;

    public VendingMachineItem(String slotIdentifier, Integer stock, String purchaseMessage, BigDecimal price, String name) {
        this.slotIdentifier = slotIdentifier;
        this.price = price;
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getSlotIdentifier() {
        return slotIdentifier;
    }

    public Integer getStock() {
        return stock;
    }

    public String getPurchaseMessage() {
        return purchaseMessage;
    }

    public String getName() {
        return name;
    }
    // WORK on LATER
    //public void setStock(int stock){
  //      if()
   // }
}
