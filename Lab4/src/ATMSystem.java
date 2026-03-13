import java.util.Scanner;

interface Withdrawable {
    void withdraw(double amount); // only accounts that can withdraw will implement this
}

interface Depositable  {
    void deposit(double amount); // deposit
}

abstract class BankAccount {
    String accountNumber;
    String accountHolder;
    double balance;

    BankAccount(String n, String h, double b) {
        accountNumber=n;
        accountHolder=h;
        balance=b;
    }

    double getBalance() {
        return balance; // common method to get balance for all accounts
    }

    void displayAccountInfo() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: $" + balance);
    }

    abstract void calculateInterest();
}

class SavingsAccount extends BankAccount implements Withdrawable, Depositable { // Savings account can withdraw and deposit
    SavingsAccount(String n, String h, double b) {
        super(n, h, b); // call the constructor of BankAccount
    }
    public void withdraw(double a) {
        if (balance - a < 500) { // check if balance would drop below minimum of $500
            System.out.println("Cannot withdraw! Minimum balance is $500.");
        }
        else {
            balance -= a;
            System.out.println("Withdrawal successful! New Balance: $" + balance);
        }
    }
    public void deposit(double a) {
        balance += a;
        System.out.println("Deposit successful! New Balance: $" + balance);
    }

    void calculateInterest() {
        balance *= 1.02;  // 2% interest for savings account
        System.out.println("Interest added! New Balance: $" + balance);
    }
}

class CurrentAccount extends BankAccount implements Withdrawable, Depositable {
    CurrentAccount(String n, String h, double b) {
        super(n, h, b); // call the constructor of BankAccount
    }

    public void withdraw(double a) {
        balance -= a;
        System.out.println("Withdrawal successful! New Balance: $" + balance);
    }

    public void deposit(double a)  {
        balance += a;
        System.out.println("Deposit successful! New Balance: $" + balance);
    }

    void calculateInterest() {
        System.out.println("No interest for Current Account. :)");
    }
}

class CreditAccount extends BankAccount implements Withdrawable {
    double creditLimit = 5000;
    CreditAccount(String n, String h, double b) {
        super(n, h, b);
    }

    public void withdraw(double a) {
        if (balance - a < -creditLimit) { // if withdrawal exceeds credit limit
            System.out.println("Credit limit exceeded! :(");
        }
        else {
            balance -= a; // allow balance to go negative up to credit limit
            System.out.println("Withdrawal successful! New Balance: $" + balance);
        }
    }
    void calculateInterest() { // if balance is negative, charge 5% interest
        if (balance < 0) {
            balance *= 1.05;
            System.out.println("Interest charged! New Balance: $" + balance);
        }
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount[] accounts = {
                new SavingsAccount("Saving-001", "Skim", 1500),
                new CurrentAccount("Current-002", "Max", 3000),
                new CreditAccount("Credit-003", "Lando", 0)
        };
        int choice;

        do {
            System.out.println("\nSelect an account:\n1. Skim\n2. Max\n3. Lando\n0. Exit");
            choice = sc.nextInt();
            if (choice == 0) { // if user chooses to exit
                System.out.println("ATM System Closed. Thanks for using.");
                break;
            }
            BankAccount acc = accounts[choice - 1];
            acc.displayAccountInfo();
            if (acc instanceof Withdrawable) { // if the account can withdraw, ask for amount to withdraw
                System.out.print("Enter amount to withdraw: ");
                ((Withdrawable) acc).withdraw(sc.nextDouble());
            }
            if (acc instanceof Depositable) { //  if the account can deposit, ask for amount to deposit
                System.out.print("Enter amount to deposit: ");
                ((Depositable) acc).deposit(sc.nextDouble());
            }
            acc.calculateInterest();
        } while (choice != 0);
        sc.close();
    }
}