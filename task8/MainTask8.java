//package com.hexaware.task8;
//
//import java.util.Scanner;
//
//
//public class MainTask8 {
//	public static void main(String[] args) {
//		Account account=new Account(2201283,"saving",30000);
//		System.out.println(account);
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
//		
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
//	}
//
//
//
//
//
////
////8.3) package com.heaware.entity;
////import java.util.Scanner;
////public class Bank {
////   public static void main(String[] args) {
////       Scanner scanner = new Scanner(System.in);
////       System.out.println("Choose an account type to create:");
////       System.out.println("1. Savings Account");
////       System.out.println("2. Current Account");
////       System.out.print("Enter your choice: ");
////       int choice = scanner.nextInt();
////       scanner.nextLine(); // Consume newline left after nextInt()
////       Account account = null;
////       switch (choice) {
////           case 1:
////               account = createSavingsAccount(scanner);
////               break;
////           case 2:
////               account = createCurrentAccount(scanner);
////               break;
////           default:
////               System.out.println("Invalid choice! Exiting...");
////               return;
////       }
////       if (account != null) {
////           boolean continueTransactions = true;
////           while (continueTransactions) {
////               System.out.println("\nSelect an operation:");
////               System.out.println("1. Deposit");
////               System.out.println("2. Withdraw");
////               System.out.println("3. Exit");
////               System.out.print("Enter your choice: ");
////               int operationChoice = scanner.nextInt();
////               scanner.nextLine(); // Consume newline left after nextInt()
////               switch (operationChoice) {
////                   case 1:
////                       System.out.print("Enter amount to deposit: ");
////                       double depositAmount = scanner.nextDouble();
////                       account.deposit(depositAmount);
////                       account.printInfo(); // Print updated account information
////                       break;
////                   case 2:
////                       System.out.print("Enter amount to withdraw: ");
////                       double withdrawAmount = scanner.nextDouble();
////                       account.withdraw(withdrawAmount);
////                       account.printInfo(); // Print updated account information
////                       break;
////                   case 3:
////                       continueTransactions = false;
////                       break;
////                   default:
////                       System.out.println("Invalid choice! Please try again.");
////               }
////           }
////       }
////   }
////
////
////   private static Account createSavingsAccount(Scanner scanner) {
////       System.out.print("Enter Account ID: ");
////       int accountId = scanner.nextInt();
////       scanner.nextLine(); // Consume newline left after nextInt()
////       System.out.print("Enter Customer ID: ");
////       int customerId = scanner.nextInt();
////       scanner.nextLine(); // Consume newline left after nextInt()
////       System.out.print("Enter Account Number: ");
////       String accountNumber = scanner.nextLine();
////       System.out.print("Enter Initial Account Balance: ");
////       double initialBalance = scanner.nextDouble();
////       scanner.nextLine(); // Consume newline left after nextDouble()
////       System.out.print("Enter Interest Rate: ");
////       double interestRate = scanner.nextDouble();
////       scanner.nextLine(); // Consume newline left after nextDouble()
////       return new SavingsAccount(accountId, customerId, accountNumber, "Savings", initialBalance, interestRate);
////   }
////
////
////   private static Account createCurrentAccount(Scanner scanner) {
////       System.out.print("Enter Account ID: ");
////       int accountId = scanner.nextInt();
////       scanner.nextLine(); // Consume newline left after nextInt()
////       System.out.print("Enter Customer ID: ");
////       int customerId = scanner.nextInt();
////       scanner.nextLine(); // Consume newline left after nextInt()
////       System.out.print("Enter Account Number: ");
////       String accountNumber = scanner.nextLine();
////       System.out.print("Enter Initial Account Balance: ");
////       double initialBalance = scanner.nextDouble();
////       scanner.nextLine(); // Consume newline left after nextDouble()
////       return new CurrentAccount(accountId, customerId, accountNumber, "Current", initialBalance);
////   }
////}