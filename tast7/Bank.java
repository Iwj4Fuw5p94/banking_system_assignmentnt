package com.hexaware.tast7;

import java.util.Scanner;

public class Bank {
	public static void main(String[] args) {
		Account account=new Account(2201283,"saving",30000);
		System.out.println(account);
		Scanner scanner=new Scanner(System.in);
		String ch=null;
		do {
			
			System.out.println("please enter 1 to withdraw amount");
			System.out.println("please enter 2 to deposit amount");
			System.out.println("please enter 3 to calculate interest amount");
			System.out.println("please enter 4 to exit");

			int Choice=scanner.nextInt();
			switch (Choice) {
			
			case 1:
				System.out.println("please enter the amount .you want to withdraw");
				int amount=scanner.nextInt();
				account.withdraw(amount);
				break;
	
			case 2:
				System.out.println("please enter the amount .you want to deposit");
				int amount1=scanner.nextInt();
				account.deposit(amount1);
				break;
			case 3:
				account.calcullateInterest();
				break;
			default:
				System.out.println("chose proper ");
				break;
						
			}
			System.out.println("do u want to continue y||Y");
		    ch=scanner.next();
		}
	
		while(ch.equals("Y") || ch.equals("y"));
		System.out.println("thank you for using ");
		}
		
	}




