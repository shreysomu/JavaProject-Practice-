package com.basicAtm.project;


import java.util.Scanner;

class ATM {
    private final int pin = 4567;
    private double balance;
    private final Scanner sc = new Scanner(System.in);

    public void checkPin() {
        while (true) {
            int enteredPin = getIntInput("Enter Your Pin:");
            if (enteredPin == pin) {
                menu();
                break;
            } else {
                System.out.println("Invalid Pin. Try again.");
            }
        }
    }

    public void menu() {
        while (true) {
            System.out.println("\n=== ATM MENU ===");
            System.out.println("1. Check A/C Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Exit");

            int choice = getIntInput("Enter your choice:");
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdrawMoney();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void checkBalance() {
        System.out.println("Your current balance is: " + balance);
    }

    public void withdrawMoney() {
        double amount = getDoubleInput("Enter amount to withdraw:");
        if (amount > balance) {
            System.out.println("Insufficient Balance. Current balance: " + balance);
        } else {
            balance -= amount;
            System.out.println("Money withdrawn successfully. New balance: " + balance);
        }
    }

    public void depositMoney() {
        double amount = getDoubleInput("Enter the amount to deposit:");
        balance += amount;
        System.out.println("Money deposited successfully. New balance: " + balance);
    }

    private int getIntInput(String message) {
        while (true) {
            try {
                System.out.println(message);
                return sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); // Clear the invalid input
            }
        }
    }

    private double getDoubleInput(String message) {
        while (true) {
            try {
                System.out.println(message);
                return sc.nextDouble();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid amount.");
                sc.next(); // Clear the invalid input
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.checkPin();
    }
}
