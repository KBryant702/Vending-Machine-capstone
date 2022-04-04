package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Inventory {
    private File inventoryList = new File("C:\\Users\\First\\Desktop\\Kimberly Bryant Student Exercises\\Pair Programming\\module-1-capstone\\capstone\\vendingmachine.csv");

public void populateInventory() {
    try (Scanner inventoryScanner = new Scanner(inventoryList)){
        while (inventoryScanner.hasNextLine()) {
            System.out.println(inventoryScanner.nextLine());
        }
    }catch (FileNotFoundException e){
        System.out.println(e.getMessage());
    }
    }





    //Scanner


}
