package com.hexaware.task11.service;
import com.hexaware.task11.bean.*;
import com.hexaware.task11.app.*;
import com.hexaware.task11.service.*;
import java.util.Map;

public class CustomerServiceProviderImpl implements ICustomerServiceProvider {
    public Map<Long, Account> accounts;
    

    public CustomerServiceProviderImpl(Map<Long, Account> accounts) {
        this.accounts = accounts;
    }
    

    public CustomerServiceProviderImpl() {
		// TODO Auto-generated constructor stub
	}


	@Override
    public double getAccountBalance(long accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            return accounts.get(accountNumber).getAccountBalance();
        } else {
            System.out.println("Account not found.");
            return -1;
        }
    }

    @Override
    public double deposit(long accountNumber, float amount) {
        if (accounts.containsKey(accountNumber)) {
            Account account = accounts.get(accountNumber);
            account.setAccountBalance(account.getAccountBalance() + amount);
            System.out.println("Deposit successful. New balance: $" + account.getAccountBalance());
            return account.getAccountBalance();
        } else {
            System.out.println("Account not found.");
            return -1;
        }
    }

    @Override
    public double withdraw(long accountNumber, float amount) {
        if (accounts.containsKey(accountNumber)) {
            Account account = accounts.get(accountNumber);

            // Check for minimum balance in case of SavingsAccount
            if (account instanceof SavingsAccount) {
                SavingsAccount savingsAccount = (SavingsAccount) account;
                double minimumBalance = SavingsAccount.MINIMUM_BALANCE;

                if (account.getAccountBalance() - amount >= minimumBalance) {
                    account.setAccountBalance(account.getAccountBalance() - amount);
                    System.out.println("Withdrawal successful. New balance: $" + account.getAccountBalance());
                    return account.getAccountBalance();
                } else {
                    System.out.println("Withdrawal violates minimum balance rule.");
                    return -1;
                }
            } else {
                // For other account types
                if (account.getAccountBalance() >= amount) {
                    account.setAccountBalance(account.getAccountBalance() - amount);
                    System.out.println("Withdrawal successful. New balance: $" + account.getAccountBalance());
                    return account.getAccountBalance();
                } else {
                    System.out.println("Insufficient balance for withdrawal.");
                    return -1;
                }
            }
        } else {
            System.out.println("Account not found.");
            return -1;
        }
    }

    @Override
    public void transfer(long fromAccountNumber, long toAccountNumber, float amount) {
        double fromBalance = withdraw(fromAccountNumber, amount);
        if (fromBalance != -1) {
            deposit(toAccountNumber, amount);
        } else {
            System.out.println("Transfer failed.");
        }
    }

    @Override
    public String getAccountDetails(long accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            Account account = accounts.get(accountNumber);
            StringBuilder details = new StringBuilder();
            details.append("Account Number: ").append(account.getAccountNumber()).append("\n");
            details.append("Account Type: ").append(account.getAccountType()).append("\n");
            details.append("Account Balance: $").append(account.getAccountBalance()).append("\n");
            details.append("Customer Information:\n");
            details.append("Customer ID: ").append(account.getCustomer().getCustomerId()).append("\n");
            details.append("First Name: ").append(account.getCustomer().getFirstName()).append("\n");
            details.append("Last Name: ").append(account.getCustomer().getLastName()).append("\n");
            details.append("Email Address: ").append(account.getCustomer().getEmailAddress()).append("\n");
            details.append("Phone Number: ").append(account.getCustomer().getPhoneNumber()).append("\n");
            details.append("Address: ").append(account.getCustomer().getAddress()).append("\n");

            return details.toString();
        } else {
            return "Account not found.";
        }
    }

    public void createAccount(Customer customer, long accNo, String accType, float balance) {
        Account newAccount = new Account();
//        newAccount.setAccountNumber(accNo);
        newAccount.setAccountType(accType);
        newAccount.setAccountBalance(balance);
        newAccount.setCustomer(customer);

        accounts.put(accNo, newAccount);

        System.out.println("Account created successfully. Account Number: " + accNo);
    }
	public double deposit1(long accountNumber, float amount) {
		// TODO Auto-generated method stub
		return 0;
	}
}
