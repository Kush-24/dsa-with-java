package com.kush.studyplan.oops.bank;

import java.util.List;
import java.util.ArrayList;


public class Bank {
    private List<Customer> customers;

    public Bank() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void displayCustomerInfo() {
        for (Customer customer : customers) {
            System.out.println("Customer: " + customer.getName());
            System.out.println("Account Number: " + customer.getAccount().getAccountNumber());
            System.out.println("Balance: $" + customer.getAccount().getBalance());
            System.out.println("----------------------------");
        }
    }

    public static void main(String[] args) {
        // Creating a Bank
        Bank bank = new Bank();

        // Creating BankAccounts and Customers
        BankAccount account1 = new BankAccount("12345", 1000);
        BankAccount account2 = new BankAccount("67890", 500);

        Customer customer1 = new Customer("John Doe", account1);
        Customer customer2 = new Customer("Jane Smith", account2);

        // Adding Customers to the Bank
        bank.addCustomer(customer1);
        bank.addCustomer(customer2);

        // Displaying Customer Information
        bank.displayCustomerInfo();

        // Example transactions
        customer1.getAccount().deposit(200);
        customer2.getAccount().withdraw(100);

        // Displaying updated Customer Information
        bank.displayCustomerInfo();
    }
}
