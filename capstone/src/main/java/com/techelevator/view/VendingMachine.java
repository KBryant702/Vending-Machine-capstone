package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {
    private Map<String, Product> items = new LinkedHashMap<>();
    private File inventoryList = new File("C:\\Users\\First\\Desktop\\Kimberly Bryant Student Exercises\\Pair Programming\\module-1-capstone\\capstone\\vendingmachine.csv");
    private double balance;
    private String strBalance;

    public VendingMachine (String filePath){
        inventoryList = new File(filePath);
        populateInventory();
        balance = 0.0;
    }

    public Map<String, Product> getItems() {
        return items;
    }

    public double getBalance() {
        return balance;
    }

    public String getStrBalance() {
        return NumberFormat.getCurrencyInstance(Locale.US).format(balance);
    }
    public void feedMoney(int feedAmount){
        balance += feedAmount;
    }
    public void spendMoney(double price){
        balance -= price;
    }



    public void vend(String slot){
        boolean slotExists = items.containsKey(slot);

        if (slotExists) {
            Product vendedItem = items.get(slot);
            if (vendedItem.getStock() > 0 && balance >= vendedItem.getPrice()) {
                spendMoney(vendedItem.getPrice());
                vendedItem.decreaseStock();
                System.out.println();
                System.out.println("Name: " + vendedItem.getName() + ", Price: " + vendedItem.getStrPrice() + ", New Balance: " + getStrBalance() + "\n" + vendedItem.getMessage());

            } else {
                if (vendedItem.getStock()< 1) {
                    System.out.println();
                    System.out.println("Item is sold out!");
                } else {
                    System.out.println();
                    System.out.println("There is not enough money provided! Please provide more money!");
                }
            }
        } else {
            System.out.println();
            System.out.println("Slot does not exist!");
        }
    }
    public void populateInventory() {
        try (Scanner inventoryScanner = new Scanner(inventoryList)){
            while (inventoryScanner.hasNextLine()) {
                String [] itemArray = inventoryScanner.nextLine().split("\\|");
                items.put(itemArray [0],new Product(itemArray));

            }

        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    public void displayInventory(){
        System.out.println();
        System.out.println("VENDING MACHINE ITEMS");
        System.out.println();
        System.out.printf("%-5s %-8s %-20s %-8s\n", "Slot", "Price", "Name", "Left");
        System.out.println("-----------------------------------------");
        for (Map.Entry<String, Product> entry: items.entrySet())
        {
            Product item = entry.getValue();
            if (item.getStock() < 1) {
//                Vendable soldOutItem = soldOutItems.get(slot);
                System.out.printf("%-5s %-8s %-20s %-15s\n", item.getSlot(), item.getStrPrice(), item.getName(), "SOLD OUT!");
                continue;
            }else{

                System.out.printf("%-5s %-8s %-20s %-15s\n", item.getSlot(), item.getStrPrice(), item.getName(), item.getStock());
            }

        }
    }

}
