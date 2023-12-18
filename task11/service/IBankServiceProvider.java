package com.hexaware.task11.service;
import com.hexaware.task11.bean.*;
import com.hexaware.task11.app.*;
import com.hexaware.task11.service.*;
public interface IBankServiceProvider {
   public void createAccount(Customer customer, long accNo, String accType, float balance);
   Account[] listAccounts();
   void calculateInterest();
public String getAccountDetails(long accountNumber);


}
