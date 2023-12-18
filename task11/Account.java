//package com.hexaware.task11;
//
//public class Account {
//    public static int lastAccNo = 1000; // Static variable for generating account numbers
//    public int accountNumber;
//    public String accountType;
//    public double accountBalance;
//    public Customer customer;
//
//    // Default constructor
//    public Account() {
//        this.accountNumber = generateAccountNumber();
//        this.accountType = "Savings"; // Default account type
//        this.accountBalance = 0.0; // Default account balance
//        this.customer = new Customer(); // Default customer
//    }
//
//    // Overloaded constructor with Account attributes
//    public Account(String accountType, double accountBalance, Customer customer) {
//        this.accountNumber = generateAccountNumber();
//        this.accountType = accountType;
//        this.accountBalance = accountBalance;
//        this.customer = customer;
//    }
//
//    // Getter and setter methods
//    public int getAccountNumber() {
//        return accountNumber;
//    }
//
//    public String getAccountType() {
//        return accountType;
//    }
//
//    public void setAccountType(String accountType) {
//        this.accountType = accountType;
//    }
//
//    public double getAccountBalance() {
//        return accountBalance;
//    }
//
//    public void setAccountBalance(double accountBalance) {
//        this.accountBalance = accountBalance;
//    }
//
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//
//    // Print all information of attributes
//    public void printAccountInformation() {
//        System.out.println("Account Number: " + accountNumber);
//        System.out.println("Account Type: " + accountType);
//        System.out.println("Account Balance: $" + accountBalance);
//        System.out.println("Customer Information:");
//        customer.printCustomerInformation();
//    }
//
//    // Generate account number using static variable
//    private static int generateAccountNumber() {
//        return ++lastAccNo;
//    }
//
//	public void calculateInterest() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void withdraw(double amount) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public static int getLastAccNo() {
//		return lastAccNo;
//	}
//
//	public static void setLastAccNo(int lastAccNo) {
//		Account.lastAccNo = lastAccNo;
//	}
//
//	public void setAccountNumber(int accountNumber) {
//		this.accountNumber = accountNumber;
//	}
//}