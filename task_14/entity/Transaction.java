package com.hexaware.task_14.entity;

import java.sql.Date;

public class Transaction {
	public Account account;
	public String description;
	public Date dateAndTime;
	public TransactionType transactiontype;
	public double transactionAmount;
	public Transaction(Account account, String description, Date dateAndTime, TransactionType transactiontype,
			double transactionAmount) {
		this.account = account;
		this.description = description;
		this.dateAndTime = dateAndTime;
		this.transactiontype = transactiontype;
		this.transactionAmount = transactionAmount;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateAndTime() {
		return dateAndTime;
	}
	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	public TransactionType getTransactiontype() {
		return transactiontype;
	}
	public void setTransactiontype(TransactionType transactiontype) {
		this.transactiontype = transactiontype;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	@Override
	public String toString() {
		return "Transaction [account=" + account + ", description=" + description + ", dateAndTime=" + dateAndTime
				+ ", transactiontype=" + transactiontype + ", transactionAmount=" + transactionAmount + "]";
	}
	
	
	

}
