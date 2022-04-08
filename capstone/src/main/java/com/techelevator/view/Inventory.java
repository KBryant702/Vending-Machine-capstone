package com.techelevator.view;

import java.io.*;
import java.text.NumberFormat;
import java.util.*;

public class Inventory{

    private File inventoryList = new File("C:\\Users\\First\\Desktop\\Kimberly Bryant Student Exercises\\Pair Programming\\module-1-capstone\\capstone\\vendingmachine.csv");
    private Map<String, Product> items = new LinkedHashMap<>();

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
