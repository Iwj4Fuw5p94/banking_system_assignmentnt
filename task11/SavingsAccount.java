//package com.hexaware.task11;
//
//class SavingsAccount extends Account{
//    private double interestRate;
//    public static final double MINIMUM_BALANCE = 500.0;
//
//    // Default constructor for SavingsAccount
//    public SavingsAccount() {
//        super("Savings", MINIMUM_BALANCE, new Customer());
//        this.interestRate = 0.0; // Default interest rate
//    }
//
//    // Overloaded constructor with SavingsAccount attributes
//    public SavingsAccount(double interestRate, Customer customer) {
//        super("Savings", MINIMUM_BALANCE, customer);
//        this.interestRate = interestRate;
//    }
//
//    // Override calculateInterest() method
//    @Override
//    public void calculateInterest() {
//        double interest = getAccountBalance() * interestRate;
//        setAccountBalance(getAccountBalance() + interest);
//        System.out.println("Interest calculated and added. New balance: $" + getAccountBalance());
//    }
//}