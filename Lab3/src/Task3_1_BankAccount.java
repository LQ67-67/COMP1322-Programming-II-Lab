public class Task3_1_BankAccount {
    private String accountNumber; // stores account number
    private double balance; // stores money amount

    Task3_1_BankAccount(String accountNumber, double startingBalance) {
        this.accountNumber = accountNumber; // set account number
        this.balance = startingBalance; // set starting balance
    }

    double getBalance() {
        return balance; // return current balance
    }

    void deposit(double amount) {
        if (amount > 0) { // check the amount is positive or not
            balance = balance + amount; // add to balance
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!"); // reject negative input
        }
    }

    // shows the account info
    void displayInfo() {
        System.out.println("Account Number: " + accountNumber); // print account number
        System.out.println("Balance: " + balance); // print balance
    }

    public static void main(String[] args) {
        // Create a bank account object
        Task3_1_BankAccount account = new Task3_1_BankAccount("Account-001", 667.7);

        account.displayInfo(); // show starting info

        account.deposit(7766.0); // deposit some money

        System.out.println("New balance: " + account.getBalance()); // check balance using getter
    }
}
