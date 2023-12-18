//package com.hexaware.task11;
//
//import java.util.Scanner;
//
//
//
//public class BankApp {
//    public static void main(String[] args) {
//        IBankServiceProvider bankService = new BankServiceProviderImpl("Main Branch", "123 Main St");
//
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            System.out.println("----- Bank Menu -----");
//            System.out.println("1. Create Account");
//            System.out.println("2. Deposit");
//            System.out.println("3. Withdraw");
//            System.out.println("4. Get Balance");
//            System.out.println("5. Transfer");
//            System.out.println("6. Get Account Details");
//            System.out.println("7. List Accounts");
//            System.out.println("8. Exit");
//            System.out.print("Enter your choice: ");
//
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // Consume the newline
//
//            switch (choice) {
//                case 1:
//                    createAccountSubMenu(bankService, scanner);
//                    break;
//                case 2:
//                    performDeposit(bankService, scanner);
//                    break;
//                case 3:
//                    performWithdraw(bankService, scanner);
//                    break;
//                case 4:
//                    getBalance(bankService, scanner);
//                    break;
//                case 5:
//                    performTransfer(bankService, scanner);
//                    break;
//                case 6:
//                    getAccountDetails(bankService, scanner);
//                    break;
//                case 7:
//                    listAccounts(bankService);
//                    break;
//                case 8:
//                    System.out.println("Exiting the bank app. Goodbye!");
//                    System.exit(0);
//                    break;
//                default:
//                    System.out.println("Invalid choice. Please enter a valid option.");
//            }
//        }
//    }
//
//    private static void createAccountSubMenu(IBankServiceProvider bankService, Scanner scanner) {
//        while (true) {
//            System.out.println("----- Create Account Menu -----");
//            System.out.println("1. Savings Account");
//            System.out.println("2. Current Account");
//            System.out.println("3. Zero Balance Account");
//            System.out.println("4. Back to Main Menu");
//            System.out.print("Enter your choice: ");
//
//            int accountChoice = scanner.nextInt();
//            scanner.nextLine(); // Consume the newline
//
//            switch (accountChoice) {
//                case 1:
//                    createAccount(bankService, "Savings", scanner);
//                    break;
//                case 2:
//                    createAccount(bankService, "Current", scanner);
//                    break;
//                case 3:
//                    createAccount(bankService, "ZeroBalance", scanner);
//                    break;
//                case 4:
//                    return; // Back to the main menu
//                default:
//                    System.out.println("Invalid choice. Please enter a valid option.");
//            }
//        }
//    }
//
//    private static void createAccount(IBankServiceProvider bankService, String accountType, Scanner scanner) {
//        System.out.print("Enter customer first name: ");
//        String firstName = scanner.nextLine();
//
//        System.out.print("Enter customer last name: ");
//        String lastName = scanner.nextLine();
//
//        System.out.print("Enter customer email address: ");
//        String emailAddress = scanner.nextLine();
//
//        System.out.print("Enter customer phone number: ");
//        String phoneNumber = scanner.nextLine();
//
//        System.out.print("Enter customer address: ");
//        String address = scanner.nextLine();
//
//        System.out.print("Enter initial balance: ");
//        float initialBalance = scanner.nextFloat();
//        scanner.nextLine(); // Consume the newline
//
//        Customer customer = new Customer(0, firstName, lastName, emailAddress, phoneNumber, address);
//        long accountNumber = System.currentTimeMillis(); // Using timestamp as a temporary account number
//
//        bankService.createAccount(customer, accountNumber, accountType, initialBalance);
//        System.out.println("Account created successfully. Account Number: " + accountNumber);
//    }
//
//    private static void performDeposit(IBankServiceProvider bankService, Scanner scanner) {
//        System.out.print("Enter account number: ");
//        long accountNumber = scanner.nextLong();
//        scanner.nextLine(); // Consume the newline
//
//        System.out.print("Enter deposit amount: ");
//        float amount = scanner.nextFloat();
//        scanner.nextLine(); // Consume the newline
//
//        double newBalance = bankService.deposit(accountNumber, amount);
//        if (newBalance != -1) {
//            System.out.println("Deposit successful. New balance: $" + newBalance);
//        } else {
//            System.out.println("Deposit failed. Please check the account number.");
//        }
//    }
//
//    private static void performWithdraw(IBankServiceProvider bankService, Scanner scanner) {
//        System.out.print("Enter account number: ");
//        long accountNumber = scanner.nextLong();
//        scanner.nextLine(); // Consume the newline
//
//        System.out.print("Enter withdrawal amount: ");
//        float amount = scanner.nextFloat();
//        scanner.nextLine(); // Consume the newline
//
//        double newBalance = bankService.withdraw(accountNumber, amount);
//        if (newBalance != -1) {
//            System.out.println("Withdrawal successful. New balance: $" + newBalance);
//        } else {
//            System.out.println("Withdrawal failed. Please check the account number.");
//        }
//    }
//
//    private static void getBalance(IBankServiceProvider bankService, Scanner scanner) {
//        System.out.print("Enter account number: ");
//        long accountNumber = scanner.nextLong();
//        scanner.nextLine(); // Consume the newline
//
//        double balance = bankService.getAccountBalance(accountNumber);
//        if (balance != -1) {
//            System.out.println("Current balance: $" + balance);
//        } else {
//            System.out.println("Balance retrieval failed. Please check the account number.");
//        }
//    }
//
//    private static void performTransfer(IBankServiceProvider bankService, Scanner scanner) {
//        System.out.print("Enter from account number: ");
//        long fromAccountNumber = scanner.nextLong();
//        scanner.nextLine(); // Consume the newline
//
//        System.out.print("Enter to account number: ");
//        long toAccountNumber = scanner.nextLong();
//        scanner.nextLine(); // Consume the newline
//
//        System.out.print("Enter transfer amount: ");
//        float amount = scanner.nextFloat();
//        scanner.nextLine(); // Consume the newline
//
//        bankService.transfer(fromAccountNumber, toAccountNumber, amount);
//    }
//
//    private static void getAccountDetails(IBankServiceProvider bankService, Scanner scanner) {
//        System.out.print("Enter account number: ");
//        long accountNumber = scanner.nextLong();
//        scanner.nextLine(); // Consume the newline
//
//        String accountDetails = bankService.getAccountDetails(accountNumber);
//        System.out.println(accountDetails);
//    }
//
//    private static void listAccounts(IBankServiceProvider bankService) {
//        Account[] accounts = bankService.listAccounts();
//
//        if (accounts.length > 0) {
//            System.out.println("----- List of Accounts -----");
//            for (Account account : accounts) {
//                System.out.println("Account Number: " + account.getAccountNumber());
//                System.out.println("Account Type: " + account.getAccountType());
//                System.out.println("Account Balance: $" + account.getAccountBalance());
//                System.out.println("Customer: " + account.getCustomer().getFirstName() + " " + account.getCustomer().getLastName());
//                System.out.println("---------------------------");
//            }
//        } else {
//            System.out.println("No accounts found.");
//        }
//    }
//}
