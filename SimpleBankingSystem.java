import java.util.Scanner;

class BankAccount {
    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}

public class SimpleBankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account holder's name: ");
        String accountHolderName = scanner.nextLine();
        BankAccount account = new BankAccount(accountHolderName);

        String command;
        System.out.println("Welcome to the Simple Banking System!");
        System.out.println("Available commands: deposit, withdraw, balance, exit");

        while (true) {
            System.out.print("Enter a command: ");
            command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "deposit":
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    account.deposit(depositAmount);
                    break;
                case "withdraw":
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    account.withdraw(withdrawAmount);
                    break;
                case "balance":
                    System.out.println("Current balance: " + account.getBalance());
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
}
