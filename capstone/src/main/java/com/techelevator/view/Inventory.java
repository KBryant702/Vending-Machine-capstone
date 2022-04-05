package com.techelevator.view;

import java.io.*;
import java.util.*;

public class Inventory{

    private List<String> vendingItems = new ArrayList<>();
    private File inventoryList = new File("C:\\Users\\First\\Desktop\\Kimberly Bryant Student Exercises\\Pair Programming\\module-1-capstone\\capstone\\vendingmachine.csv");
    private Map<String, Integer> inventoryItems = new HashMap<>();

    public void populateInventory() {
    try (Scanner inventoryScanner = new Scanner(inventoryList)){
        while (inventoryScanner.hasNextLine()) {
            String item = inventoryScanner.nextLine();
            int lastIndex = item.lastIndexOf("|") +1;
            vendingItems.add(item.substring(0,lastIndex));
        inventoryItems.put(item.substring(0,lastIndex), 5);
        }

    }catch (FileNotFoundException e){
        System.out.println(e.getMessage());
    }
    }
    public void displayInventory(){
        for (String item: vendingItems
             ) {
            System.out.println(item + inventoryItems.get(item));

        }
    }
}
