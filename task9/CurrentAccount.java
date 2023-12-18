package com.hexaware.task9;

class CurrentAccount extends BankAccount {
    private static final double OVERDRAFT_LIMIT = 1000.0;

    // Constructor
    public CurrentAccount(String accountNumber, String customerName, double balance) {
        super(accountNumber, customerName, balance);
    }

    // Implement abstract methods
    @Override
    public void deposit(double amount) {
    
        balance += amount;
        System.out.println("Deposit of $" + amount + " successful. New balance: $" + balance);
    }

    @Override
    public void withdraw(double amount){
        if ((balance - amount) >= -OVERDRAFT_LIMIT) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful. New balance: $" + balance);
        } else {
            System.out.println("Withdrawal limit exceeded. Withdrawal failed.");
        }
    }

    @Override
    public void calculateInterest() {
        // Current account has no interest
        System.out.println("Current account does not earn interest.");
    }
}


