package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Inventory extends Menu{
    private File inventoryList = new File("C:\\Users\\First\\Desktop\\Kimberly Bryant Student Exercises\\Pair Programming\\module-1-capstone\\capstone\\vendingmachine.csv");

    public Inventory(InputStream input, OutputStream output) {
        super(input, output);
    }


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
