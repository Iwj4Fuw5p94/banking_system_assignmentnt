package com.hexaware.task_14.app;

import java.util.Scanner;

import com.hexaware.task_14.entity.CurrentAccount;
import com.hexaware.task_14.entity.Customer;
import com.hexaware.task_14.entity.SavingsAccount;
import com.hexaware.task_14.entity.ZeroBalanceAccount;
import com.hexaware.task_14.service.IBankRepository;

public class BankApp {
    public static void main(String[] args) {
        IBankRepository bankRepository = new BankRepositoryImpl(); // Assuming you have implemented this class
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Get Balance");
            System.out.println("5. Transfer");
            System.out.println("6. Get Account Details");
            System.out.println("7. List Accounts");
            System.out.println("8. Get Transactions");
            System.out.println("9. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccount(bankRepository, scanner);
                    break;
                case 2:
                    deposit(bankRepository, scanner);
                    break;
                case 3:
                    withdraw(bankRepository, scanner);
                    break;
                case 4:
                    getBalance(bankRepository, scanner);
                    break;
                case 5:
                    transfer(bankRepository, scanner);
                    break;
                case 6:
                    getAccountDetails(bankRepository, scanner);
                    break;
                case 7:
                    listAccounts(bankRepository);
                    break;
                case 8:
                    getTransactions(bankRepository, scanner);
                    break;
                case 9:
                    System.out.println("Exiting BankApp. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    // Define methods like createAccount, deposit, withdraw, getBalance, transfer, getAccountDetails, listAccounts, getTransactions
    // ...

    private static void createAccount(IBankRepository bankRepository, Scanner scanner) {
        System.out.println("Choose account type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.println("3. Zero Balance Account");

        int accountTypeChoice = scanner.nextInt();

        switch (accountTypeChoice) {
            case 1:
                createSavingsAccount(bankRepository, scanner);
                break;
            case 2:
                createCurrentAccount(bankRepository, scanner);
                break;
            case 3:
                createZeroBalanceAccount(bankRepository, scanner);
                break;
            default:
                System.out.println("Invalid account type choice.");
        }
    }
    private static void createSavingsAccount(IBankRepository bankRepository, Scanner scanner) {
        System.out.print("Enter customer name: ");
        String customerName = scanner.next();
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        System.out.print("Enter interest rate: ");
        float interestRate = scanner.nextFloat();

        Customer customer = new Customer(customerName);
        SavingsAccount savingsAccount = new SavingsAccount(initialBalance, interestRate, customer);
        
        // Call the repository to store the account in the database
        bankRepository.createAccount(customer, savingsAccount.getAccountNumber(), "Savings", initialBalance);
        
        System.out.println("Savings Account created successfully.");
    }

    private static void createCurrentAccount(IBankRepository bankRepository, Scanner scanner) {
        System.out.print("Enter customer name: ");
        String customerName = scanner.next();
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        System.out.print("Enter overdraft limit: ");
        int overdraftLimit = scanner.nextInt();

        Customer customer = new Customer(customerName);
        CurrentAccount currentAccount = new CurrentAccount(initialBalance, overdraftLimit, customer);

        // Call the repository to store the account in the database
        bankRepository.createAccount(customer, currentAccount.getAccountNumber(), "Current", initialBalance);

        System.out.println("Current Account created successfully.");
    }

    private static void createZeroBalanceAccount(IBankRepository bankRepository, Scanner scanner) {
        System.out.print("Enter customer name: ");
        String customerName = scanner.next();

        Customer customer = new Customer(customerName);
        ZeroBalanceAccount zeroBalanceAccount = new ZeroBalanceAccount(customer);

        // Call the repository to store the account in the database
        bankRepository.createAccount(customer, zeroBalanceAccount.getAccountNumber(), "ZeroBalance", 0);

        System.out.println("Zero Balance Account created successfully.");
    }


    // Define createSavingsAccount, createCurrentAccount, createZeroBalanceAccount, and other helper methods
    // ...
}
