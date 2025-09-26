
import java.util.Scanner;

public class Bank {
    static double balance = 200;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Check debit card balance");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Exit app");

            System.out.print("Enter your option: ");
            int option = scanner.nextInt();

            if (option < 1 || option > 4) {
                System.out.println("Please enter a valid option.");
                continue;
            }

            switch (option) {
                case 1 -> checkBalance();
                case 2 -> depositMoney(scanner);
                case 3 -> withdrawMoney(scanner);
                case 4 -> {
                    System.out.println("Exiting app. Goodbye!");
                    scanner.close();
                    return;
                }
            }

            System.out.print("Would you like to continue with another option? (y/n): ");
            String restart = scanner.next();

            if (restart.equalsIgnoreCase("n")) {
                System.out.println("Exiting app. Goodbye!");
                break;
            }

            System.out.println();
        }

        scanner.close();
    }

    public static void checkBalance() {
        System.out.println("Your current balance amount: " + balance + " EUR");
    }

    public static void depositMoney(Scanner scanner) {
        System.out.print("Enter the amount you want to deposit: ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }

        balance += amount;
        checkBalance();
    }

    public static void withdrawMoney(Scanner scanner) {
        System.out.print("Enter the amount you want to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return;
        }

        balance -= amount;
        System.out.println("You withdrew " + amount + " EUR");
        checkBalance();
    }
}
