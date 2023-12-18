package com.hexaware.task12;

public class Account {
    private int accountNumber;
    private double balance;

    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public double withDraw(double amount) throws InsufficientFundException,OverDraftLimitExceededException {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("WithDraw Successfully");
            return balance;
        } else {
            throw new InsufficientFundException("Insufficient funds");
        }
    }

    public double calculateInterest() {
        double interestRate = 0.045;
        return balance += balance * interestRate;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return  "accountNumber=" + accountNumber +
                ", balance=" + balance;
    }
}

