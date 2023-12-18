package com.hexaware.task_14.service;

import java.util.List;

import com.hexaware.task_14.entity.Transaction;

import java.util.Date;
import java.util.List;
public interface IBankServiceProvider {
   double getAccountBalance(long accountNumber);
   double deposit(long accountNumber, double amount);
   double withdraw(long accountNumber, double amount);
   boolean transfer(long fromAccountNumber, long toAccountNumber, double amount);
   String getAccountDetails(long accountNumber);
  
   List<Transaction> getTransactions(long accountNumber, Date fromDate, Date toDate);
}
