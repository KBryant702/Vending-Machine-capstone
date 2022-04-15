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
    private File inventoryList;
    private double balance;

    public VendingMachine(String filePath) {
        inventoryList = new File(filePath);
        populateInventory();
        balance = 0.0;
    }

    public String getStrBalance() {
        return NumberFormat.getCurrencyInstance(Locale.US).format(balance);
    }

    public Map<String, Product> getItems() {
        return items;
    }

    public void feedMoney(int feedAmount) {
        String oldBalance = getStrBalance();
        balance += feedAmount;
        String newBalance = getStrBalance();
        //log the change of money balance
        TransactionLog.commitChange("Feed Money", oldBalance, newBalance);
    }

    //Checks if enough stock and money for purchase, decreases stock when purchased
    public void vend(String slot) {
        boolean slotExists = items.containsKey(slot); //checks if slot input exists

        if (slotExists) {
            Product vendedItem = items.get(slot);
            if (vendedItem.getStock() > 0 && balance >= vendedItem.getPrice()) {
                String oldBalance = getStrBalance();
                balance -= vendedItem.getPrice();
                String newBalance = getStrBalance();
                vendedItem.decreaseStock();
                TransactionLog.commitChange((vendedItem.getName() + " " + vendedItem.getSlot()), oldBalance, newBalance);
                System.out.println();
                System.out.println("Name: " + vendedItem.getName() + ", Price: " + vendedItem.getStrPrice()
                        + ", New Balance: " + getStrBalance() + "\n" + vendedItem.getMessage());

            } else {
                if (vendedItem.getStock() < 1) {
                    System.out.println();
                    System.out.println("Item is sold out!");
                } else {
                    System.out.println();
                    System.out.println("Not enough money provided! Please provide more money!");
                }
            }
        } else {
            System.out.println();
            System.out.println("Slot does not exist! Make another selection.");
        }
    }

    public String returnChange() {
        if (balance == 0.0) {
            return ("");
        }
        int[] change = calculateChange(balance);
        String oldBalance = getStrBalance();
        balance = 0.0;
        String newBalance = getStrBalance();
        TransactionLog.commitChange("Return Change", oldBalance, newBalance);
        return ("Returned Change: " + change[0] + " Quarter(s), " + change[1] + " Dime(s) & " + change[2] + " Nickel(s)!");
    }

    //get exact number of each coin denomination for returned change
    private int[] calculateChange(double amount) {
        int nickels = 0;
        int dimes = 0;
        int quarters = 0;
        if (amount > 0) {
            amount *= 100;
            quarters = (int) Math.floor(amount / 25);
            amount %= 25;
        }
        if (amount > 0) {
            dimes = (int) Math.floor(amount / 10);
            amount %= 10;
        }
        if (amount > 0) {
            nickels = (int) Math.floor(amount / 5);
        }
        return new int[]{quarters, dimes, nickels};

    }

    public void populateInventory() {
        try (Scanner inventoryScanner = new Scanner(inventoryList)) {
            while (inventoryScanner.hasNextLine()) {
                String[] itemArray = inventoryScanner.nextLine().split("\\|");
                items.put(itemArray[0], new Product(itemArray));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayInventory() {
        System.out.println();
        System.out.println("VENDING MACHINE ITEMS");
        System.out.println();
        System.out.printf("%-5s %-8s %-20s %-8s\n", "Slot", "Price", "Name", "Left");
        System.out.println("-----------------------------------------");
        for (Map.Entry<String, Product> entry : items.entrySet()) {
            Product item = entry.getValue();
            if (item.getStock() < 1) {
                System.out.printf("%-5s %-8s %-20s %-15s\n", item.getSlot(), item.getStrPrice(), item.getName(), "SOLD OUT!");
            } else {
                System.out.printf("%-5s %-8s %-20s %-15s\n", item.getSlot(), item.getStrPrice(), item.getName(), item.getStock());
            }
        }
    }
}
