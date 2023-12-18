package com.hexaware.task_14.entity;

public class Validator {
	public static boolean isValidPhoneNumber(String phoneNumber){
		return phoneNumber.matches("\\d{10}");
		
	}
	public static boolean isValidEmail(String email){	
		 return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
	}

}
