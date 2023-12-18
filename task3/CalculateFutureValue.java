package com.hexaware.task3;
import java.util.Scanner;
public class CalculateFutureValue{	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Compound Interest Calculator!");
        // Prompt the user for the number of customers
        System.out.print("Enter the number of customers: ");
        int numberOfCustomers = scanner.nextInt();
        for (int customerIndex = 1; customerIndex <= numberOfCustomers; customerIndex++) {
            System.out.println("\nCustomer " + customerIndex);
            // Prompt the user for initial balance, annual interest rate, and number of years
            System.out.print("Enter the initial balance for customer " + customerIndex + ": $");
            double initialBalance = scanner.nextDouble();

            System.out.print("Enter the annual interest rate for customer " + customerIndex + " (%): ");
            double annualInterestRate = scanner.nextDouble();

            System.out.print("Enter the number of years for customer " + customerIndex + ": ");
            int numberOfYears = scanner.nextInt();

            // Calculate the future balance using the compound interest formula
            double futureBalance = calculateFutureBalance(initialBalance, annualInterestRate, numberOfYears);

            // Display the future balance for the customer
            System.out.println("Future balance for customer " + customerIndex + ": $" + futureBalance);
        }
    }
//    Method to calculate future balance using the compound interest formula
    private static double calculateFutureBalance(double initialBalance, double annualInterestRate, int numberOfYears) {
        double rate = 1 + (annualInterestRate / 100);
        return initialBalance * Math.pow(rate, numberOfYears);
    }
}
