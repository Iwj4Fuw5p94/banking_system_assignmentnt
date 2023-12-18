package com.hexaware.task_14.entity;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountType, int accountBalance, Customer customer, double interestRate) {
        super(accountType, accountBalance, customer);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    // Add additional methods related to savings account if needed
}