package com.hexaware.task12;

public class SavingAccount extends Account {
    private double interestRate;

    public SavingAccount(int accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        double interestRate = 0.045;
        return super.calculateInterest();
    }

    @Override
    public String toString() {
        return "SavingAccount{" +super.toString()+
                ", interestRate=" + interestRate +
                '}';
    }
}
