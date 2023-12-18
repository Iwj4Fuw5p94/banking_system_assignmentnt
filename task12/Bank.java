package com.hexaware.task12;
import java.util.Scanner;
public class Bank {
    public static SavingAccount createSavingsAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account number: ");
        int accNum = scanner.nextInt();
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        System.out.print("Enter interest rate for Savings Account: ");
        double interestRate = scanner.nextDouble();
        return new SavingAccount(accNum, initialBalance, interestRate);
    }

    public static CurrentAccount createCurrentAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account number: ");
        int accNum = scanner.nextInt();
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        return new CurrentAccount(accNum, initialBalance);
    }

    public static void operateAccount(Account account) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nAccount Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Calculate Interest (for Savings Account)");
            System.out.println("4. Check account balance");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int accountChoice = scanner.nextInt();

            switch (accountChoice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    try {
                        account.withDraw(withdrawalAmount);
                    } catch (InsufficientFundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }catch (OverDraftLimitExceededException ee){
                        System.out.println(ee.getMessage());
                    }
                    break;

                case 3:
                    if (account instanceof SavingAccount) {
                        ((SavingAccount) account).calculateInterest();
                    } else {
                        System.out.println("Interest calculation is applicable only for Savings Account.");
                    }
                    break;
                case 4:
                    System.out.println(account.getBalance());
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = null;

        System.out.println("Welcome to the Bank!");

        while (true) {
            System.out.println("Main Menu:");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int mainChoice = scanner.nextInt();

            switch (mainChoice) {
                case 1:
                    account = createSavingsAccount();
                    System.out.println(account);
                    break;

                case 2:
                    account = createCurrentAccount();
                    System.out.println(account);
                    break;

                case 3:
                    System.out.println("Exiting the Bank. Thank you!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            if (account != null) {
                operateAccount(account);
            }
        }
    }
}
