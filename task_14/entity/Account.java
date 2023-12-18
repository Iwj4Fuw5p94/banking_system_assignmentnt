package com.hexaware.task_14.entity;

public class Account {
	private static int accountNumber;
	private String accountType;
	private int accountBalance;
	Customer customer;
	
	public Account(String accountType, int accountBalance, Customer customer) {
		super();
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.customer = customer;
	}
	public static int getAccountNumber() {
		return accountNumber;
	}
	public static void setAccountNumber(int accountNumber) {
		Account.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public int getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
