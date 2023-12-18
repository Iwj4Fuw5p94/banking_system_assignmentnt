package com.hexaware.task12;

public class Customer {
    private int CustomerID;
    private String FirstName;
    private String LastName;
    private String EmailAddress;
    private int Phone;
    private String Address;

    public Customer() {
    }

    public Customer(int customerID, String firstName, String lastName, String emailAddress, int phone, String address) {
        CustomerID = customerID;
        FirstName = firstName;
        LastName = lastName;
        EmailAddress = emailAddress;
        Phone = phone;
        Address = address;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
