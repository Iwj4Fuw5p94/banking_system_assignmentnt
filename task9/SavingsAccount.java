package com.hexaware.task9;
class SavingsAccount extends BankAccount {
    private double interestRate;

    // Constructor
    public SavingsAccount(String accountNumber, String customerName, double balance, double interestRate) {
        super(accountNumber, customerName, balance);
        this.interestRate = interestRate;
    }

    // Implement abstract methods
    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit of $" + amount + " successful. New balance: $" + balance);
    }

    @Override
    public void withdraw(double amount){
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful. New balance: $" + balance);
        } else {
          System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }

    @Override
    public void calculateInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("Interest calculated and added. New balance: $" + balance);
    }
}
