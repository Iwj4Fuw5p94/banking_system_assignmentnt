package com.hexaware.tast7;

import java.util.Scanner;

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
			System.out.println("amount succesfully addedd");
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
//	public static void main(String[] args) {
//		Account account=new Account();
//		account.setAccountBalance(20000);
//		Scanner scanner=new Scanner(System.in);
//		String ch=null;
//		do {
//			
//			System.out.println("please enter 1 to withdraw amount");
//			System.out.println("please enter 2 to deposit amount");
//			System.out.println("please enter 3 to calculate interest amount");
//			System.out.println("please enter 4 to exit");
//
//			int Choice=scanner.nextInt();
//			switch (Choice) {
//			
//			case 1:
//				System.out.println("please enter the amount .you want to withdraw");
//				int amount=scanner.nextInt();
//				account.withdraw(amount);
//				break;
//	
//			case 2:
//				System.out.println("please enter the amount .you want to deposit");
//				int amount1=scanner.nextInt();
//				account.deposit(amount1);
//				break;
//			case 3:
//				account.calcullateInterest();
//				break;
//			default:
//				System.out.println("chose proper ");
//				break;
//						
//			}
//			System.out.println("do u want to continue y||Y");
//		    ch=scanner.next();
//		}
//	
//		while(ch.equals("Y") || ch.equals("y"));
//		System.out.println("thank you for using ");
//		}
//		
	}

