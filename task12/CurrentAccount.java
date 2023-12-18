package com.hexaware.task12;

public class CurrentAccount extends Account {
    private static final double OVERDRAFT_LIMIT = 1000.0;

    public CurrentAccount(int accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public double withDraw(double amount) throws InsufficientFundException,OverDraftLimitExceededException{
        if (super.getBalance() - amount >= -OVERDRAFT_LIMIT) {
            return super.withDraw(amount);
        } else {
            throw new OverDraftLimitExceededException("Overdraft limit exceeded");
        }
    }

    @Override
    public String toString() {
        return "CurrentAccount{"+super.toString()+"}";
    }
}
