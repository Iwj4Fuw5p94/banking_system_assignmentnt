package com.hexaware.task11.service;
import com.hexaware.task11.bean.*;
import com.hexaware.task11.app.*;
import com.hexaware.task11.service.*;

import java.util.ArrayList;
import java.util.List;
public class BankServiceProviderImpl extends CustomerServiceProviderImpl implements IBankServiceProvider {
    private List<Account> accountList;
    private String branchName;
    private String branchAddress;

    public BankServiceProviderImpl(String branchName, String branchAddress) {
        super(); // Call the constructor of the superclass (CustomerServiceProviderImpl)
        this.accountList = new ArrayList<>();
        this.branchName = branchName;
        this.branchAddress = branchAddress;
    }

    @Override
    public void createAccount(Customer customer, long accNo, String accType, float balance) {
        // Create an account using IBankServiceProvider's createAccount method
        super.createAccount(customer, accNo, accType, balance);

        // Retrieve the created account and add it to the accountList
        Account newAccount = findAccount(accNo);
        if (newAccount != null) {
            accountList.add(newAccount);
        }
    }

    @Override
    public Account[] listAccounts() {
        return accountList.toArray(new Account[0]);
    }

    @Override
    public void calculateInterest() {
        for (Account account : accountList) {
            if (account instanceof SavingsAccount) {
                SavingsAccount savingsAccount = (SavingsAccount) account;
                savingsAccount.calculateInterest();
            }
        }
    }

    private Account findAccount(long accountNumber) {
        for (Account account : accountList) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    // Additional methods for BankServiceProviderImpl specific functionalities
    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

	@Override
	public void createAccount(com.com.hexaware.task_14.entity.Customer customer, long accNo, String accType,
			float balance) {
		// TODO Auto-generated method stub
		
	}
}
