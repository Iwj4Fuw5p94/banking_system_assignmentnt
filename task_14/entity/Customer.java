package com.hexaware.task_14.entity;

public class Customer {

	    public int customerId;
	    public String firstName;
	    public String lastName;
	    public String emailAddress;
	    public String phoneNumber;
	    public String address;

	    // Default constructor
	    public Customer() {
	        this.customerId = 0;
	        this.firstName = "";
	        this.lastName = "";
	        this.emailAddress = "";
	        this.phoneNumber = "";
	        this.address = "";
	    }

	    // Overloaded constructor
	    public Customer(int customerId, String firstName, String lastName, String emailAddress, String phoneNumber, String address) {
	        this.customerId = customerId;
	        this.firstName = firstName;
	        this.lastName = lastName;

	        // Validate and set email address
	        if (Validator.isValidEmail(emailAddress)) {
	            this.emailAddress = emailAddress;
	        } else {
	            throw new IllegalArgumentException("Invalid email address");
	        }

	        // Validate and set phone number
	        if (Validator.isValidPhoneNumber(phoneNumber)) {
	            this.phoneNumber = phoneNumber;
	        } else {
	            throw new IllegalArgumentException("Invalid phone number");
	        }

	        this.address = address;
	    }

	    // Getter and setter methods
	    public int getCustomerId() {
	        return customerId;
	    }

	    public void setCustomerId(int customerId) {
	        this.customerId = customerId;
	    }

	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public String getEmailAddress() {
	        return emailAddress;
	    }

	    public void setEmailAddress(String emailAddress) {
	        if (Validator.isValidEmail(emailAddress)) {
	            this.emailAddress = emailAddress;
	        } else {
	            throw new IllegalArgumentException("Invalid email address");
	        }
	    }

	    public String getPhoneNumber() {
	        return phoneNumber;
	    }

	    public void setPhoneNumber(String phoneNumber) {
	        if (Validator.isValidPhoneNumber(phoneNumber)) {
	            this.phoneNumber = phoneNumber;
	        } else {
	            throw new IllegalArgumentException("Invalid phone number");
	        }
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }
	    // Print customer information
	    public void printCustomerInfo() {
	        System.out.println("Customer ID: " + customerId);
	        System.out.println("Name: " + firstName + " " + lastName);
	        System.out.println("Email: " + emailAddress);
	        System.out.println("Phone Number: " + phoneNumber);
	        System.out.println("Address: " + address);
	    }
	}