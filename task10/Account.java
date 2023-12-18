package com.hexaware.task10;

public class Account {
    private static long accountNumberCounter = 1001;
    private long accountNumber;
    private String accountType;
    private float balance;
    private Customer customer;
    // Default constructor
    public Account() {
        this.accountNumber = generateAccountNumber();
        this.accountType = "";
        this.balance = 0.0f;
        this.customer = new Customer();
    }
    // Overloaded constructor
    public Account(String accountType, float balance, Customer customer) {
        this.accountNumber = generateAccountNumber();
        this.accountType = accountType;
        this.balance = balance;
        this.customer = customer;
    }

    // Getter and setter methods
    public long getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // Print account information
    public void printAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: $" + balance);
        System.out.println("Customer Information:");
        customer.printCustomerInfo();
    }

    // Generate a unique account number
    private static synchronized long generateAccountNumber() {
        return accountNumberCounter++;
    }
}
