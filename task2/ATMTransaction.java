package com.hexaware.task2;

import java.util.Scanner;

public class ATMTransaction {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
//		get current balance
		System.out.println("enter your current balance");
		int currentBalance=sc.nextInt();
//		display the options 
		System.out.println("enter 1 to check balamce");
		System.out.println("enter 2 to withdraw");
		System.out.println("enter 3 to deposit");
		System.out.println("enter 4 to exit");
		int choice =sc.nextInt();	
		switch (choice) {
		case 1:
			System.out.println("current balance is "+currentBalance);
			
			break;
		case 2:
			// Withdraw
            System.out.print("Enter the amount to withdraw: $");
            int withdrawAmount = sc.nextInt();

            // Check if withdrawal amount is valid
            if (withdrawAmount > 0 && withdrawAmount <= currentBalance) {
                if (withdrawAmount % 100 == 0 || withdrawAmount % 500 == 0) {
                    currentBalance -= withdrawAmount;
                    System.out.println("Withdrawal successful. Remaining balance: $" + currentBalance);
                } else {
                    System.out.println("Withdrawal amount must be in multiples of 100 or 500.");
                }
            } else {
                System.out.println("Invalid withdrawal amount. Insufficient funds.");
            }
            break;

		case 3:
			 System.out.print("Enter the amount to deposit: $");
             int depositAmount = sc.nextInt();

             // Check if deposit amount is valid
             if (depositAmount > 0) {
                 currentBalance += depositAmount;
                 System.out.println("Deposit successful. New balance: $" + currentBalance);
             } else {
                 System.out.println("Invalid deposit amount.");
             }
             break;
		case 4:
			
			System.out.println("now u are out of the loop ");
			System.exit(0);
			break;
		
		default:
			System.out.println("you have entered wrong input ");

			break;
		}
		}
	

		
	

}
