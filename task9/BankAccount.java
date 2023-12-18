package com.hexaware.task9;

public abstract class BankAccount {
	 private String accountNumber;
	 private String customerName;
	 protected double balance;
	 public BankAccount() {}
	public BankAccount(String accountNumber, String customerName, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.customerName = customerName;
		this.balance = balance;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	  public abstract void deposit(double amount);

	  public abstract void withdraw(double amount);

	  public abstract void calculateInterest();
	

}
