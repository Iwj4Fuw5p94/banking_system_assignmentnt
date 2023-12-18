package com.hexaware.task8;

import java.util.Scanner;

public class SavingsAccount extends Account{
	double interestRate;
	public SavingsAccount() {}
	public SavingsAccount(int accountNumber,double accountBalance,double interestRate) {
		super(accountNumber,"saving", accountBalance);
		this.interestRate=interestRate;
	}
	@Override
	public void calcullateInterest() {
		System.out.println("enter interest rate");
		Scanner scanner=new Scanner(System.in);
		interestRate=scanner.nextDouble();
		double interestAmount=(super.getAccountBalance()*interestRate*1)/100;
		System.out.println("interest amount is "+interestAmount);
		System.out.println(getAccountBalance());

	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public static void main(String[] args) {
		SavingsAccount savingsAccount=new SavingsAccount(10122,200000,4);
		System.out.println(savingsAccount);
		savingsAccount.calcullateInterest();
	}
}
