package com.hexaware;

//BankServiceProviderImpl.java

import java.util.HashMap;
import java.util.Map;

class InsufficientFundException extends Exception {
 public InsufficientFundException(String message) {
     super(message);
 }
}

class InvalidAccountException extends Exception {
 public InvalidAccountException(String message) {
     super(message);
 }
}

class OverDraftLimitExceededException extends Exception {
 public OverDraftLimitExceededException(String message) {
     super(message);
 }
}


interface IBankServiceProvider {
 double withdraw(long accountNumber, float amount) throws InsufficientFundException, InvalidAccountException;

 void transfer(long fromAccountNumber, long toAccountNumber, float amount)
         throws InsufficientFundException, InvalidAccountException;

 double overdraftWithdraw(long accountNumber, float amount)
         throws OverDraftLimitExceededException, InvalidAccountException;

 // Other methods as needed
}

class BankServiceProviderImpl implements IBankServiceProvider {
 private Map<Long, Account1> accounts;

 public BankServiceProviderImpl() {
     this.accounts = new HashMap<>();
     // Add sample accounts (for demonstration purposes)
     accounts.put(1L, new Account1());
     accounts.put(2L, new Account1());
 }

 @Override
 public double withdraw(long accountNumber, float amount) throws InsufficientFundException, InvalidAccountException {
     if (accounts.containsKey(accountNumber)) {
         Account1 account = accounts.get(accountNumber);

         if (account.getAccountBalance() >= amount) {
             account.setAccountBalance(account.getAccountBalance() - amount);
             System.out.println("Withdrawal successful. New balance: $" + account.getAccountBalance());
             return account.getAccountBalance();
         } else {
             throw new InsufficientFundException("Insufficient funds for withdrawal. Current balance: $" + account.getAccountBalance());
         }
     } else {
         throw new InvalidAccountException("Account not found. Please check the account number.");
     }
 }

 @Override
 public void transfer(long fromAccountNumber, long toAccountNumber, float amount)
         throws InsufficientFundException, InvalidAccountException {
     if (accounts.containsKey(fromAccountNumber) && accounts.containsKey(toAccountNumber)) {
         Account1 fromAccount = accounts.get(fromAccountNumber);

         if (fromAccount.getAccountBalance() >= amount) {
             // Withdraw from the sender's account
             fromAccount.setAccountBalance(fromAccount.getAccountBalance() - amount);

             // Deposit into the receiver's account
             Account1 toAccount = accounts.get(toAccountNumber);
             toAccount.setAccountBalance(toAccount.getAccountBalance() + amount);

             System.out.println("Transfer successful.");
             System.out.println("From Account " + fromAccountNumber + ": New balance: $" + fromAccount.getAccountBalance());
             System.out.println("To Account " + toAccountNumber + ": New balance: $" + toAccount.getAccountBalance());
         } else {
             throw new InsufficientFundException("Insufficient funds for transfer. Current balance: $" + fromAccount.getAccountBalance());
         }
     } else {
         throw new InvalidAccountException("Account not found. Please check the account numbers.");
     }
 }

 @Override
 public double overdraftWithdraw(long accountNumber, float amount)
         throws OverDraftLimitExceededException, InvalidAccountException {
     if (accounts.containsKey(accountNumber)) {
         Account1 account = accounts.get(accountNumber);

         // Assuming overdraft limit is configured as a constant in the Account class
         double overdraftLimit = account.getOverdraftLimit();

         if (account.getAccountBalance() + overdraftLimit >= amount) {
             account.setAccountBalance(account.getAccountBalance() - amount);
             System.out.println("Withdrawal successful. New balance: $" + account.getAccountBalance());
             return account.getAccountBalance();
         } else {
             throw new OverDraftLimitExceededException("Overdraft limit exceeded. Current balance: $" + account.getAccountBalance());
         }
     } else {
         throw new InvalidAccountException("Account not found. Please check the account number.");
     }
 }

 // Other methods as needed

}

public class BankApp {
 public static void main(String[] args) {
     IBankServiceProvider bankService = new BankServiceProviderImpl();

     try {
         // Example: Withdrawal
         System.out.println("----- Example: Withdrawal -----");
         bankService.withdraw(1L, 50);

         // Example: Transfer
         System.out.println("\n----- Example: Transfer -----");
         bankService.transfer(1L, 2L, 30);

         // Example: Overdraft Withdrawal
         System.out.println("\n----- Example: Overdraft Withdrawal -----");
         ((BankServiceProviderImpl) bankService).overdraftWithdraw(2L, 80);
     } catch (InsufficientFundException | InvalidAccountException | OverDraftLimitExceededException e) {
         System.out.println("Error: " + e.getMessage());
     } catch (Exception e) {
         System.out.println("An unexpected error occurred: " + e.getMessage());
     }
 }
}
