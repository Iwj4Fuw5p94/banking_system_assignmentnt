package com.hexaware.task6;

import java.util.ArrayList;
import java.util.Scanner;

public class PasswordValidation {
	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);

	        // Initialize transaction history list
	        ArrayList<Double> transactionHistory = new ArrayList<>();

	        // Use a while loop to allow the user to keep adding transactions
	        while (true) {
	            System.out.println("Choose an option:");
	            System.out.println("1. Deposit");
	            System.out.println("2. Withdraw");
	            System.out.println("3. Exit");

	            int choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter deposit amount: $");
	                    double depositAmount = scanner.nextDouble();
	                    transactionHistory.add(depositAmount);
	                    System.out.println("Deposit of $" + depositAmount + " recorded.");
	                    break;

	                case 2:
	                    System.out.print("Enter withdrawal amount: $");
	                    double withdrawalAmount = scanner.nextDouble();
	                    transactionHistory.add(-withdrawalAmount); // Represent withdrawal as a negative amount
	                    System.out.println("Withdrawal of $" + withdrawalAmount + " recorded.");
	                    break;

	                case 3:
	                    System.out.println("Exiting...");

	                    // Display transaction history
	                    System.out.println("Transaction History:");
	                    for (int i = 0; i < transactionHistory.size(); i++) {
	                        double amount = transactionHistory.get(i);
	                        String transactionType = amount >= 0 ? "Deposit" : "Withdrawal";
	                        System.out.println(transactionType + ": $" + Math.abs(amount));
	                    }
	                    scanner.close();
	                    System.exit(0);

	                default:
	                    System.out.println("Invalid option. Please choose again.");
	            }
	        }
	    }
}
