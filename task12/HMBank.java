package com.hexaware.task12;

import java.util.*;

public class HMBank {
    private List<Account> accountsList = new ArrayList<>();
    private Set<Account> accountsSet = new HashSet<>();
    private Map<Integer, Account> accountsMap = new HashMap<>();
    private List<Account> allAccounts=new ArrayList<>();
    public SavingAccount createSavingsAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account number: ");
        int accNum = scanner.nextInt();
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        System.out.print("Enter interest rate for Savings Account: ");
        double interestRate = scanner.nextDouble();

        SavingAccount savingAccount = new SavingAccount(accNum, initialBalance, interestRate);
        accountsList.add(savingAccount);
        accountsSet.add(savingAccount);
        accountsMap.put(accNum, savingAccount);

        return savingAccount;
    }

    public CurrentAccount createCurrentAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account number: ");
        int accNum = scanner.nextInt();
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();

        CurrentAccount currentAccount = new CurrentAccount(accNum, initialBalance);

        accountsList.add(currentAccount);

        accountsSet.add(currentAccount);

        accountsMap.put(accNum, currentAccount);

        return currentAccount;
    }

    public void operateAccount(Account account) throws NullPointerException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nAccount Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Calculate Interest (for Savings Account)");
            System.out.println("4. Check account balance");
            System.out.println("5. Back to Main Menu");
            System.out.println("Enter your choice: ");

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
                    } catch (OverDraftLimitExceededException ee) {
                        System.out.println(ee.getMessage());
                    }
                    break;

                case 3:
                    if (account instanceof SavingAccount) {
                        ((SavingAccount) account).calculateInterest();
                    } else {
                        throw new NullPointerException("Interest calculation is applicable only for Savings Account. ");

                    }
                    break;

                case 4:
                    System.out.println("Account Balance: " + account.getBalance());
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public  void listAccounts() throws InterruptedException {
        Set<Account> sortedSet = new TreeSet<>(Comparator.comparing(Account::getAccountNumber));
        sortedSet.addAll(accountsSet);

        System.out.println("List of Accounts (Sorted by Account Number):");
        if(sortedSet.size()==0) {
            System.out.println("No Account is present\n");
            Thread.sleep(3000);
        }
        else {
            for (Account account : sortedSet) {
                System.out.println(account);
            }
        }
    }

    public static void main(String[] args) {
        HMBank bank = new HMBank();
        Scanner scanner = new Scanner(System.in);
        Account account = null;

        System.out.println("Welcome to the Bank!");

        while (true) {
            System.out.println("\t\tMain Menu:");
            System.out.println("\t\t1. Create Savings Account");
            System.out.println("\t\t2. Create Current Account");
            System.out.println("\t\t3. List Accounts");
            System.out.println("\t\t4. Exit");
            System.out.print("\t\tEnter your choice: ");

            int mainChoice = scanner.nextInt();

            switch (mainChoice) {
                case 1:
                    account = bank.createSavingsAccount();
                    System.out.println("Account created: " + account);
                    break;

                case 2:
                    account = bank.createCurrentAccount();
                    System.out.println("Account created: " + account);
                    break;

                case 3:
                    try {
                        bank.listAccounts();
                    }catch (InterruptedException ie){
                        System.out.println(ie.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Exiting the Bank. Thank you!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            if (account != null) {
                try {
                    bank.operateAccount(account);
                }catch (NullPointerException ne){
                    System.out.println(ne);
                }

            }
        }
    }
}

