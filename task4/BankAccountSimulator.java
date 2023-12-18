package com.hexaware.task4;

import java.awt.Choice;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankAccountSimulator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        int[] accountNumbers = {10015467, 10027657, 10036555, 16787004};
        double[] accountBalances = {1500.0, 2000.0, 2500.0, 3000.0};

        System.out.println("Welcome to the Bank Account Simulator!");

        // Loop to repeatedly ask for account number and balance
        boolean validAccount = false;
        while (!validAccount) {
            // Prompt the user to enter the account number
            System.out.print("Enter your account number: ");
            int enteredAccountNumber = scanner.nextInt();

            // Validate the account number
            int accountIndex = findAccountIndex(accountNumbers, enteredAccountNumber);
            if (accountIndex != -1) {
                // Display the account balance if the account number is valid
                System.out.println("Account Balance: $" + accountBalances[accountIndex]);
                validAccount = true;
            } else {
                // Ask the user to try again if the account number is not valid
                System.out.println("Invalid account number. Please try again.");
            }
        }

        // Close the scanner to avoid resource leak
        scanner.close();
    }

    // Method to find the index of an account number in the array
    private static int findAccountIndex(int[] accountNumbers, int targetAccountNumber) {
        for (int i = 0; i < accountNumbers.length; i++) {
            if (accountNumbers[i] == targetAccountNumber) {
                return i; // Found the account number, return its index
            }
        }
        return -1; // Account number not found in the array
    }
}


