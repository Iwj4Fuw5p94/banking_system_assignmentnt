package com.hexaware.task8;

public class Account {
	private int accountNumber;
	private String accountType;
	private double accountBalance;
	public Account() {}
	
	public Account(int accountNumber, String accountType, double accountBalance) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
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
	public void deposit(float amount) {
		if(amount>=0) {
			accountBalance=accountBalance+amount;
			System.out.println("amount(float) succesfully addedd");
			System.out.println(accountBalance);
			System.out.println("deposit methiod called");
		}
		else {
			System.out.println("invalid amount");
		}
		
	}
	public void deposit(int amount) {
		if(amount>=0) {
			accountBalance=accountBalance+amount;
			System.out.println("amount(int) succesfully addedd");
			System.out.println(accountBalance);
			System.out.println("deposit methiod called");
		}
		else {
			System.out.println("invalid amount");
		}
		
	}
	public void deposit(double amount) {
		if(amount>=0) {
			accountBalance=accountBalance+amount;
			System.out.println("amount(double) succesfully addedd");
			System.out.println(accountBalance);
			System.out.println("deposit methiod called");
		}
		else {
			System.out.println("invalid amount");
		}
		
	}
	public void withdraw(float amount) {
		if(amount > 0 && accountBalance >= amount) {
			accountBalance-=amount;
			System.out.println("withdraw(float) amount is"+amount);

			System.out.println("remaining account is "+accountBalance);
			System.out.println("withdraw method is called");
		}
		else {
			System.out.println("insufficient balance.");
		}
	}
	public void withdraw(int amount) {
		if(amount>0 && accountBalance>=amount){
			accountBalance-=amount;
			System.out.println("withdraw(int) amount is"+amount);
			System.out.println("remaining account is "+accountBalance);
			System.out.println("withdraw method is called");
		}
		else {
			System.out.println("insufficient balance.");
		}
		
	}
	public void withdraw(double amount) {
		if(amount>0 && accountBalance>=amount){
			accountBalance-=amount;
			System.out.println("withdraw(double) amount is"+amount);
			System.out.println("remaining account is "+accountBalance);
			System.out.println("withdraw method is called");
		}
		else {
			System.out.println("insufficient balance.");
		}
		
	}
	public void calcullateInterest() {
		double interestRate=4.5;
		double interestAmount=(accountBalance*interestRate*1)/100;
		System.out.println("interest amount is "+interestAmount);

	}
	@Override
	public String toString() {
		return "    [accountNumber=" + accountNumber + "\n"+ " accountType=" + accountType +"\n"+ ", accountBalance="+ accountBalance + "]";
	}
}