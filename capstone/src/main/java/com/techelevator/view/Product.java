package com.techelevator.view;


import java.text.NumberFormat;
import java.util.Locale;

public class Product {
    private String type;
    private String slot;
    private int stock = 5;
    private String message;
    private double price;
    private String name;
    private String strPrice;

    public Product(String [] itemArray) {
        this.slot = itemArray[0];
        this.name = itemArray[1];
        this.price = Double.parseDouble(itemArray[2]);
        this.type = itemArray[3];
        switch (type) {
            case "Candy":
                this.message = ("Munch Munch, Yum!");
                break;
            case "Drink":
                this.message = ("Glug Glug, Yum!");
                break;
            case "Chip":
                this.message = ("Crunch Crunch, Yum!");
                break;
            case "Gum":
                this.message = "Chew Chew, Yum!";
                break;
        }
    }
    public void decreaseStock(){
        stock -= 1;
    }

    public String getStrPrice() {
        return NumberFormat.getCurrencyInstance(Locale.US).format(price);
    }

    public double getPrice() {
        return price;
    }

    public String getSlot() {
        return slot;
    }

    public Integer getStock() {
        return stock;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }
    // WORK on LATER
    //public void setStock(int stock){
  //      if()
   // }
}
