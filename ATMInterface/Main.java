package com.aot.test;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	// 1. Bank Account Logic with Transaction History
    static class BankAccount {
        private double balance;
        private ArrayList<String> history;

        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
            this.history = new ArrayList<>();
            this.history.add("Account opened with initial balance: ₹" + initialBalance);
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                history.add("Deposited: ₹" + amount + " | New Balance: ₹" + balance);
                System.out.println("Successfully deposited: ₹" + amount);
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }

        public boolean withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                history.add("Withdrew: ₹" + amount + " | New Balance: ₹" + balance);
                return true;
            }
            return false;
        }

        public void showHistory() {
            System.out.println("\n--- TRANSACTION HISTORY ---");
            if (history.isEmpty()) {
                System.out.println("No transactions recorded.");
            } else {
                for (String record : history) {
                    System.out.println(record);
                }
            }
            System.out.println("---------------------------");
        }
    }

    // 2. Main Method to handle the ATM Interface
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Starting with a balance of ₹10,000
        BankAccount userAccount = new BankAccount(10000.0); 

        int choice;
        System.out.println("Welcome to the ATM Service");

        do {
            System.out.println("\n--- ATM MENU ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: ₹" + userAccount.getBalance());
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double dAmount = scanner.nextDouble();
                    userAccount.deposit(dAmount);
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double wAmount = scanner.nextDouble();
                    if (userAccount.withdraw(wAmount)) {
                        System.out.println("Transaction Successful. Please collect ₹" + wAmount);
                    } else {
                        System.out.println("Error: Insufficient balance or invalid amount.");
                    }
                    break;

                case 4:
                    userAccount.showHistory();
                    break;

                case 5:
                    System.out.println("Thank you for using our ATM. Namaste!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

}
