package com.techelevator.view;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory{

    private List<String> vendingItems = new ArrayList<>();
    private File inventoryList = new File("C:\\Users\\First\\Desktop\\Kimberly Bryant Student Exercises\\Pair Programming\\module-1-capstone\\capstone\\vendingmachine.csv");


    public void populateInventory() {
    try (Scanner inventoryScanner = new Scanner(inventoryList)){
        while (inventoryScanner.hasNextLine()) {

            vendingItems.add(inventoryScanner.nextLine());
        }
    }catch (FileNotFoundException e){
        System.out.println(e.getMessage());
    }
    }
    public void displayInventory(){
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
