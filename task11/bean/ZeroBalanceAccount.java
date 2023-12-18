package com.hexaware.task11.bean;

class ZeroBalanceAccount extends Account {

    // Default constructor for ZeroBalanceAccount
    public ZeroBalanceAccount() {
        super("Zero Balance", 0.0, new Customer());
    }
}