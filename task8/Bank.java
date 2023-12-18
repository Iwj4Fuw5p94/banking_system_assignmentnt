package com.hexaware.task8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = null;

        System.out.println("Welcome to the Bank!");

        // Display menu to create account
        System.out.println("Choose account type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        int accountTypeChoice = scanner.nextInt();

        switch (accountTypeChoice) {
            case 1:
                account = createSavingsAccount();
                break;
            case 2:
                account = createCurrentAccount();
                break;
            default:
                System.out.println("Invalid choice. Exiting...");
                System.exit(0);
        }

        // Display operations menu
        while (true) {
            System.out.println("\nChoose operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Calculate Interest (Savings Account)");
            System.out.println("4. Exit");

            int operationChoice = scanner.nextInt();

            switch (operationChoice) {
                case 1:
                    System.out.print("Enter deposit amount: $");
                    float depositAmount = scanner.nextFloat();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: $");
                    float withdrawalAmount = scanner.nextFloat();
                    account.withdraw(withdrawalAmount);
                    break;
                case 3:
                    if (account instanceof SavingsAccount) {
//                        ((SavingsAccount) account).calculateInterest();
                    } else {
                        System.out.println("This operation is only applicable to Savings Accounts.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static SavingsAccount createSavingsAccount() {
        System.out.print("Enter account number: ");
        int accountNumber = new Scanner(System.in).nextInt();
        System.out.print("Enter initial balance: $");
        double initialBalance = new Scanner(System.in).nextDouble();
        System.out.print("Enter interest rate: ");
        double interestRate = new Scanner(System.in).nextDouble();

        return new SavingsAccount(accountNumber, initialBalance, interestRate);
    }

    private static CurrentAccount createCurrentAccount() {
        System.out.print("Enter account number: ");
        int accountNumber = new Scanner(System.in).nextInt();
        System.out.print("Enter initial balance: $");
        double initialBalance = new Scanner(System.in).nextDouble();

        return new CurrentAccount(accountNumber, initialBalance);
    }
}
