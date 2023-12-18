package com.hexaware.task11.bean;
import com.hexaware.task11.bean.*;
import com.hexaware.task11.app.*;
import com.hexaware.task11.service.*;
class CurrentAccount extends Account {
    private double overdraftLimit;

    // Default constructor for CurrentAccount
    public CurrentAccount() {
        super("Current", 0.0, new Customer());
        this.overdraftLimit = 0.0; // Default overdraft limit
    }

    // Overloaded constructor with CurrentAccount attributes
    public CurrentAccount(double overdraftLimit, Customer customer) {
        super("Current", 0.0, customer);
        this.overdraftLimit = overdraftLimit;
    }

    // Override withdraw() method to allow overdraft up to a certain limit
    @Override
    public void withdraw(double amount) {
        if (getAccountBalance() + overdraftLimit >= amount) {
            setAccountBalance(getAccountBalance() - amount);
            System.out.println("Withdrawal successful. New balance: $" + getAccountBalance());
        } else {
            System.out.println("Withdrawal exceeds overdraft limit.");
        }
    }
}