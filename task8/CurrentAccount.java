package com.hexaware.task8;

public class CurrentAccount extends Account{
    private static final double OVERDRAFT_LIMIT = 1000.0;
    

    public CurrentAccount(int accountNumber, double accountBalance) {
        super(accountNumber, "Current", accountBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && getAccountBalance() + OVERDRAFT_LIMIT >= amount) {
            setAccountBalance(getAccountBalance() - amount);
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Exceeded overdraft limit. Withdrawal not allowed.");
        }
    }
}