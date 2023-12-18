package com.hexaware.task_14.service;

import java.util.Date;
import java.util.List;

import com.hexaware.task_14.entity.Account;
import com.hexaware.task_14.entity.Customer;
import com.hexaware.task_14.entity.Transaction;

public interface IBankRepository {
    void createAccount(Customer customer, long accNo, String accType, float balance);

    List<Account> listAccounts();

    void calculateInterest();

    double getAccountBalance(long accountNumber);

    double deposit(long accountNumber, float amount);

    double withdraw(long accountNumber, float amount);

    void transfer(long fromAccountNumber, long toAccountNumber, float amount);

    Account getAccountDetails(long accountNumber);

    List<Transaction> getTransactions(long accountNumber, Date fromDate, Date toDate);
}
