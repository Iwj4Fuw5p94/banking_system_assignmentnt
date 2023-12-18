package com.hexaware.task10;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.ls.LSOutput;

public class Bank {
    private Map<Long, Account> accounts;

    // Default constructor
    public Bank() {
        this.accounts = new HashMap<>();
    }
    


	// Create a new bank account
    public void createAccount(Customer customer, String accType, float balance) {
        Account account = new Account(accType, balance, customer);
        accounts.put(account.getAccountNumber(), account);
        System.out.println("Account created successfully. Account Number: " + account.getAccountNumber());
    }

    // Retrieve the balance of an account
    public float getAccountBalance(long accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            return accounts.get(accountNumber).getBalance();
        } else {
            System.out.println("Account not found.");
            return -1;
        }
    }

    // Deposit into an account
    public float deposit(long accountNumber, float amount) {
        if (accounts.containsKey(accountNumber)) {
            Account account = accounts.get(accountNumber);
            account.setBalance(account.getBalance() + amount);
            System.out.println("Deposit successful. New balance: $" + account.getBalance());
            return account.getBalance();
        } else {
            System.out.println("Account not found.");
            return -1;
        }
    }

    // Withdraw from an account
    public float withdraw(long accountNumber, float amount) {
        if (accounts.containsKey(accountNumber)) {
            Account account = accounts.get(accountNumber);
            if (account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);
                System.out.println("Withdrawal successful. New balance: $" + account.getBalance());
                return account.getBalance();
            } else {
                System.out.println("Insufficient funds. Withdrawal failed.");
                return -1;
            }
        } else {
            System.out.println("Account not found.");
            return -1;
        }
    }
    // Transfer money between accounts
    public void transfer(long fromAccountNumber, long toAccountNumber, float amount) {
        if (accounts.containsKey(fromAccountNumber) && accounts.containsKey(toAccountNumber)) {
            Account fromAccount = accounts.get(fromAccountNumber);
            Account toAccount = accounts.get(toAccountNumber);

            if (fromAccount.getBalance() >= amount) {
                fromAccount.setBalance(fromAccount.getBalance() - amount);
                toAccount.setBalance(toAccount.getBalance() + amount);
                System.out.println("Transfer successful.");
            } else {
                System.out.println("Insufficient funds. Transfer failed.");
            }
        } else {
            System.out.println("One or more accounts not found.");
        }
    }
    public void getAccountDetails(long accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            Account account = accounts.get(accountNumber);
            account.printAccountInfo();
        } else {
            System.out.println("Account not found.");
        }
        
    }


}
