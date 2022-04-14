package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {

	private PrintWriter out;
	private Scanner in;

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}
	public Object getChoiceFromOptions(Object[] options, String message) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options, message);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}
	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	public String getSlotFromUser() {
		System.out.println();
		System.out.print("Enter the slot to vend: ");
		return in.nextLine().toUpperCase();
	}
	public int getMoneyFromUser() {
		int convertedAmount = 0;
		while(true) {
			try {
				System.out.println();
				System.out.print("Enter the amount to feed into machine: ");
				String enteredAmount = in.nextLine();
				convertedAmount = Integer.parseInt(enteredAmount);
				if (convertedAmount < 1) { // if a negative number is entered print out message to user
					System.out.println();
					System.out.println("No freebies! Please enter whole dollar amount that is greater than 0");
					continue;
				}
				break;
			} catch (Exception e) {
				System.out.println();
				System.out.println("Invalid! Please enter a whole dollar amount");
			}
		}
		return convertedAmount;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.parseInt(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if (choice == null) {
			out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" + System.lineSeparator());
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options, String message) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.println("\n" + message);
		out.print(System.lineSeparator() + "Please choose an option >>> ");
		out.flush();
	}
	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.print(System.lineSeparator() + "Please choose an option >>> ");
		out.flush();
	}
}
