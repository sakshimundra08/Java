import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    String description;
    double amount;

    public Expense(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }
}

public class ExpenseTracker {
    private static ArrayList<Expense> expenses = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String command;

        System.out.println("Welcome to the Expense Tracker!");
        System.out.println("Available commands: add, view, remove, exit");

        while (true) {
            System.out.print("Enter a command: ");
            command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "add":
                    addExpense();
                    break;
                case "view":
                    viewExpenses();
                    break;
                case "remove":
                    removeExpense();
                    break;
                case "exit":
                    System.out.println("Exiting the application.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }

    private static void addExpense() {
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        expenses.add(new Expense(description, amount));
        System.out.println("Expense added!");
    }

    private static void viewExpenses() {
        System.out.println("Expenses:");
        for (Expense expense : expenses) {
            System.out.println("Description: " + expense.description + ", Amount: " + expense.amount);
        }
    }

    private static void removeExpense() {
        System.out.print("Enter the index of the expense to remove (starting from 0): ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (index >= 0 && index < expenses.size()) {
            expenses.remove(index);
            System.out.println("Expense removed!");
        } else {
            System.out.println("Invalid index.");
        }
    }
}
