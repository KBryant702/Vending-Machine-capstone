package com.techelevator.view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TransactionLog {
    //Method that logs the commit change
    private static void log(String action) {

        File newFile = new File("log.txt");

        try {
            FileWriter fw = new FileWriter (newFile, true);
            fw.write(action);
            fw.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    //Add transaction information to log.txt
    public static void commitChange(String description, String oldBalance, String newBalance) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");
        String currentDate = formatter.format(new Date()).toUpperCase();
        String action = String.format("%-20s %-25s %-8s %-8s\n", currentDate, description, oldBalance, newBalance);
        log(action);
    }
}
