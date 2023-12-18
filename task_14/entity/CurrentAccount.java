package com.hexaware.task_14.entity;

public class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(String accountType, int accountBalance, Customer customer, double overdraftLimit) {
        super(accountType, accountBalance, customer);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    // Add additional methods related to current account if needed
}