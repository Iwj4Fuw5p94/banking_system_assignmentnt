package com.hexaware.task9;

import java.util.Scanner;

public class Bank {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose account type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");

        int choice = scanner.nextInt();
        BankAccount account = null;

        switch (choice) {
            case 1:
                account = createSavingsAccount();
                break;
            case 2:
                account = createCurrentAccount();
                break;
            default:
                System.out.println("Invalid choice. Exiting program.");
                System.exit(0);
        }

        while (true) {
            System.out.println("\nChoose operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Calculate Interest (Savings Account only)");
            System.out.println("4. Exit");

            int operation = scanner.nextInt();

            switch (operation) {
                case 1:
                    System.out.println("Enter deposit amount:");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter withdrawal amount:");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 3:
                    if (account instanceof SavingsAccount) {
                        ((SavingsAccount) account).calculateInterest();
                    } else {
                        System.out.println("Invalid operation for the selected account type.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static SavingsAccount createSavingsAccount() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter account number:");
        String accountNumber = scanner.next();

        System.out.println("Enter customer name:");
        String customerName = scanner.next();

        System.out.println("Enter initial balance:");
        double balance = scanner.nextDouble();

        System.out.println("Enter interest rate:");
        double interestRate = scanner.nextDouble();

        return new SavingsAccount(accountNumber, customerName, balance, interestRate);
    }

    private static CurrentAccount createCurrentAccount() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter account number:");
        String accountNumber = scanner.next();

        System.out.println("Enter customer name:");
        String customerName = scanner.next();

        System.out.println("Enter initial balance:");
        double balance = scanner.nextDouble();

        return new CurrentAccount(accountNumber, customerName, balance);
    }
}
