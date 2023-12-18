package com.hexaware.task13;

//File: BankServiceProviderImpl.java

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BankServiceProviderImpl implements IBankServiceProvider {
 private List<Account> accountList;

 public BankServiceProviderImpl() {
     this.accountList = new ArrayList<>();

     // Add sample accounts (for demonstration purposes)
     Account account1 = new Account(1L, "Savings", 1000.0, new Customer("John", "Doe"));
     Account account2 = new Account(2L, "Current", 500.0, new Customer("Alice", "Smith"));

     accountList.add(account1);
     accountList.add(account2);
 }

 @Override
 public List<Account> listAccounts() {
     // Sort the accounts based on customer name using a Comparator
     accountList.sort(Comparator.comparing(a -> a.getAccountOwner().getFirstName()));

     System.out.println("----- Account List -----");
     for (Account account : accountList) {
         System.out.println(account);
     }
     return accountList;
 }

 public static void main(String[] args) {
     IBankServiceProvider bankService = new BankServiceProviderImpl();

     try {
         // Example: List Accounts
         System.out.println("\n----- Example: List Accounts -----");
         bankService.listAccounts();
     } catch (Exception e) {
         System.out.println("An unexpected error occurred: " + e.getMessage());
     }
 }
}
