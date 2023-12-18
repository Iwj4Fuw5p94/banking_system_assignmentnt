package com.hexaware.task10;

import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBanking System Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Get Balance");
            System.out.println("5. Transfer");
            System.out.println("6. Get Account Details");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bank.createAccount(getCustomerInfo(), getAccountType(), getInitialBalance());
                    break;
                case 2:
                    performTransaction(bank, "deposit");
                    break;
                case 3:
                    performTransaction(bank, "withdraw");
                    break;
                case 4:
                    getBalance(bank);
                    break;
                case 5:
                    performTransfer(bank);
                    break;
                case 6:
                    getAccountDetails(bank);
                    break;
                case 7:
                    System.out.println("Exiting BankApp. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static Customer getCustomerInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Customer Information:");

        System.out.print("First Name: ");
        String firstName = scanner.next();

        System.out.print("Last Name: ");
        String lastName = scanner.next();

        System.out.print("Email Address: ");
        String emailAddress = scanner.next();

        System.out.print("Phone Number: ");
        String phoneNumber = scanner.next();

        System.out.print("Address: ");
        String address = scanner.next();

        return new Customer(0, firstName, lastName, emailAddress, phoneNumber, address);
    }

    private static String getAccountType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose Account Type:");
        System.out.println("1. Savings");
        System.out.println("2. Current");

        int choice = scanner.nextInt();
        return (choice == 1) ? "Savings" : "Current";
    }

    private static float getInitialBalance() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Initial Balance: $");
        return scanner.nextFloat();
    }

    private static void performTransaction(Bank bank, String transactionType) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Account Number: ");
        long accountNumber = scanner.nextLong();

        System.out.print("Enter Amount: $");
        float amount = scanner.nextFloat();

        switch (transactionType) {
            case "deposit":
                bank.deposit(accountNumber, amount);
                break;
            case "withdraw":
                bank.withdraw(accountNumber, amount);
                break;
            default:
                System.out.println("Invalid transaction type.");
        }
    }

    private static void getBalance(Bank bank) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Account Number: ");
        long accountNumber = scanner.nextLong();

        float balance = bank.getAccountBalance(accountNumber);
        if (balance != -1) {
            System.out.println("Current Balance: $" + balance);
        }
    }

    private static void performTransfer(Bank bank) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter From Account Number: ");
        long fromAccountNumber = scanner.nextLong();

        System.out.print("Enter To Account Number: ");
        long toAccountNumber = scanner.nextLong();

        System.out.print("Enter Amount: $");
        float amount = scanner.nextFloat();

        bank.transfer(fromAccountNumber, toAccountNumber, amount);
    }

    private static void getAccountDetails(Bank bank) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Account Number: ");
        long accountNumber = scanner.nextLong();

        bank.getAccountDetails(accountNumber);
    }
}