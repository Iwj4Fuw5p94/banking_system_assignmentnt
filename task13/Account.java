package com.hexaware.task13;

//File: Account.java

public class Account {
 private long accountNumber;
 private String accountType;
 private double accountBalance;
 private Customer accountOwner;

 public Account(long accountNumber, String accountType, double accountBalance, Customer accountOwner) {
     this.accountNumber = accountNumber;
     this.accountType = accountType;
     this.accountBalance = accountBalance;
     this.accountOwner = accountOwner;
 }
 


 public long getAccountNumber() {
	return accountNumber;
}



public void setAccountNumber(long accountNumber) {
	this.accountNumber = accountNumber;
}



public String getAccountType() {
	return accountType;
}



public void setAccountType(String accountType) {
	this.accountType = accountType;
}



public double getAccountBalance() {
	return accountBalance;
}



public void setAccountBalance(double accountBalance) {
	this.accountBalance = accountBalance;
}



public Customer getAccountOwner() {
	return accountOwner;
}



public void setAccountOwner(Customer accountOwner) {
	this.accountOwner = accountOwner;
}



@Override
 public String toString() {
     return "Account Number: " + accountNumber +
             ", Type: " + accountType +
             ", Balance: $" + accountBalance +
             ", Owner: " + accountOwner;
 }
}
