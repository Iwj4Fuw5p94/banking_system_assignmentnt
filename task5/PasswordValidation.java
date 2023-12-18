package com.hexaware.task5;

import java.util.Scanner;

public class PasswordValidation { 
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("create password");
		String passWordString=scanner.nextLine();
		if(isvalidPassword(passWordString)) {
			System.out.println("it is a valid password");
			System.out.println(passWordString);
		}
		else {
			System.out.println("it is not a valid password");
		}
	}
	public static boolean isvalidPassword(String passWordString){
		if(passWordString.length()<8) {
			return false;
		}
		if (!passWordString.matches(".*[A-Z].*")) {
			return true;
		}
		 if (!passWordString.matches(".*\\d.*")) {
	            return false;
	        }
		return true;
	}

}
