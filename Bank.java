import java.util.Scanner;

abstract class Account {
    private String customerName;
    private String accountNumber;
    private double balance;

    public Account(String customerName, String accountNumber, double initialBalance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public abstract void withdraw(double amount);

    public void displayBalance() {
        System.out.println("Current balance: $" + balance);
    }
}

class SavAcct extends Account {
    private double interestRate;

    public SavAcct(String customerName, String accountNumber, double initialBalance, double interestRate) {
        super(customerName, accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    public void computeInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
        System.out.println("Interest deposited: $" + interest);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            deposit(-amount);
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
}

class CurAcct extends Account {
    private static final double MIN_BALANCE = 500.0;
    private static final double PENALTY_CHARGE = 50.0;

    public CurAcct(String customerName, String accountNumber, double initialBalance) {
        super(customerName, accountNumber, initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            deposit(-amount);
            System.out.println("Withdrew: $" + amount);
            checkMinimumBalance();
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    private void checkMinimumBalance() {
        if (getBalance() < MIN_BALANCE) {
            deposit(-PENALTY_CHARGE);
            System.out.println("Minimum balance not maintained. Penalty of $" + PENALTY_CHARGE + " charged.");
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = null;
        System.out.println("Enter account type (savings/current): ");
        String type = scanner.nextLine().toLowerCase();
        System.out.println("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.println("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.println("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();

        if (type.equals("savings")) {
            System.out.println("Enter interest rate: ");
            double interestRate = scanner.nextDouble();
            account = new SavAcct(name, accountNumber, initialBalance, interestRate);
        } else if (type.equals("current")) {
            account = new CurAcct(name, accountNumber, initialBalance);
        } else {
            System.out.println("Invalid account type.");
            return;
        }
        while (true) {
            System.out.println("\nChoose an operation: ");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            if (account instanceof SavAcct) {
                System.out.println("4. Compute Interest");
            }
            System.out.println("5. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.displayBalance();
                    break;
                case 4:
                    if (account instanceof SavAcct) {
                        ((SavAcct) account).computeInterest();
                    } else {
                        System.out.println("This operation is not applicable to current accounts.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting.");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
