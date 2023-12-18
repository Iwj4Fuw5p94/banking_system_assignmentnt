package com.hexaware.task10;

public class Validator {
	public static boolean isValidPhoneNumber(String phoneNumber){
		return phoneNumber.matches("\\d{10}");
		
	}
	public static boolean isValidEmail(String email){	
		 return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
	}

}
