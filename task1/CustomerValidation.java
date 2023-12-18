package com.hexaware.task1;

import java.util.Scanner;


public class CustomerValidation {
	public static void main(String[] args) {
		
	
	Scanner scanner=new Scanner(System.in);
	System.out.println("enter the credit score");
	int creditScore=scanner.nextInt();
	System.out.println("enter the annual income");
	int annualIncome=scanner.nextInt();
	if(creditScore>=700 && annualIncome>=50000) {
		System.out.println("Congratulations! You are eligible for a loan. ");
	}
	else {

		System.out.println("Sorry, you are not eligible for a loan based on the provided criteria.");
	}
	}

}
