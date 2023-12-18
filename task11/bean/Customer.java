package com.hexaware.task11.bean;
import java.util.regex.Pattern;

public class Customer {
    public int customerId;
    public String firstName;
    public String lastName;
    public String emailAddress;
    public String phoneNumber;
    public String address;

    // Default constructor
    public Customer() {
        // Default values or initialization logic if needed
    }

    // Overloaded constructor with Customer attributes
    public Customer(int customerId, String firstName, String lastName,
                    String emailAddress, String phoneNumber, String address) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;

        if (isValidEmail(emailAddress)) {
            this.emailAddress = emailAddress;
        } else {
            System.out.println("Invalid email address");
        }

        if (isValidPhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Invalid phone number");
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
        if (isValidEmail(emailAddress)) {
            this.emailAddress = emailAddress;
        } else {
            System.out.println("Invalid email address");
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (isValidPhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Invalid phone number");
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Print all information of attributes
    public void printCustomerInformation() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Email Address: " + emailAddress);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Address: " + address);
    }

    // Validate email address
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return Pattern.matches(emailRegex, email);
    }

    // Validate phone number
    private boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\d{10}");
    }
}