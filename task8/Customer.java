package com.hexaware.task8;

public class Customer {
	private int customerId;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String phoneNumber;
	private String adddress;
	// Default constructor
	public Customer() {
		
	}
	// Overloaded constructor with Customer attributes

		public Customer(int customerId, String firstName, String lastName, String emailAddress, String phoneNumber,
				String adddress) {
			super();
			this.customerId = customerId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.emailAddress = emailAddress;
			this.phoneNumber = phoneNumber;
			this.adddress = adddress;
		}
	
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
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAdddress() {
		return adddress;
	}

	public void setAdddress(String adddress) {
		this.adddress = adddress;
	}
	

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailAddress=" + emailAddress + ", phoneNumber=" + phoneNumber + ", adddress=" + adddress + "]";
	}
	
}
class Smai{
	public static void main(String[] args) {
		Customer customer=new Customer(101,"krj", null, null, null, null);
		System.out.println(customer);
	}
}