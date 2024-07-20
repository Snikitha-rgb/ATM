import java.util.*;
class BankAccount {
    private String accountNumber;
    private double balance;
    Scanner sc=new Scanner(System.in);
    
   public BankAccount(String accountNumber,double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    
    public void deposit(double amount) {
       
        
        if (amount > 0) {
            balance += amount;
            System.out.printf(amount+ " deposited successfully.");
        } else {
            System.out.println("Deposit amount must be greater than zero.");
        }
    }

    
    public void withdraw(double amount) {

        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                System.out.printf(amount+" withdrawn successfully.");
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Withdrawal amount must be greater than zero.");
        }
    }


    public double checkBalance() {
        return balance;
    }
}


public class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    
    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }

    
    private void displayMenu() {
        
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }


    public void start() {
        
             
            while(true)
            {
                System.out.println();
             displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            double amount;

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    amount = scanner.nextDouble();
                    deposit(amount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    amount = scanner.nextDouble();
                    withdraw(amount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }

            
            scanner.nextLine();
           System.out.println();
        }
    }

    
    private void checkBalance() {
        double balance = bankAccount.checkBalance();
        System.out.printf("Your account balance is: "+ balance);
    }

    
    private void deposit(double amount) {
        bankAccount.deposit(amount);
    }


    private void withdraw(double amount) {
        bankAccount.withdraw(amount);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
         System.out.println("Welcome to the ATM");
        System.out.println("Enter your Account Number: ");
        String accountNum=sc.nextLine();
        
        BankAccount account = new BankAccount(accountNum,0);

        
        ATM atm = new ATM(account);

        
        atm.start();
    }
}
