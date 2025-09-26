
import java.util.Scanner;

public class Bank {
    static double balance = 200;

    public static void main(String[] args) {

        System.out.println("1. Check debit card balance");
        System.out.println("2. Deposit money");
        System.out.println("3. Withdraw money");
        System.out.println("4. Exit app");

        System.out.println("Enter your option:");
        Scanner In = new Scanner(System.in);
        int option = In.nextInt();

        if (option > 4 || option <= 0) {
            System.out.println("Please enter a valid option");
            return;
        }

        switch (option) {
            case 1 -> checkBalance();
            case 2 -> depositMoney();
            case 3 -> withdrawMoney();
        }
        In.close();
    }

    public static void checkBalance() {
        System.out.println("Your current balance amount:" + balance + " eur");
        return;
    }

    public static void depositMoney() {
        System.out.println("Enter the amount you want to deposit");
        Scanner In = new Scanner(System.in);
        int amount = In.nextInt();
        balance = balance + amount;
        In.close();
        checkBalance();
    }

    public static void withdrawMoney() {
        System.out.println("Enter the amount you want to wihtdraw:");
        Scanner In = new Scanner(System.in);
        double amount = In.nextInt();
        In.close();

        if (amount > balance) {
            System.out.println("Insufficient funds");
            return;
        }

        balance = balance - amount;
        System.out.println("You withdrew " + amount + " eur");
        checkBalance();
    }

}
