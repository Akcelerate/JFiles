package Lab_Eval;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

interface TransactionService2{
    void deposit(double amount) throws Exception;
    void withdraw(double amount) throws Exception;
}

abstract class Account2 {
    int accountNumber;
    String accountHolderName;
    double balance;
    final double minBalance = 1000;

    Account2() {
        this.accountNumber = 0000000;
        this.accountHolderName = "";
        this.balance = 0.00;
    }

    Account2(int num, String name, double bal) {
        this.balance = bal;
        this.accountHolderName = name;
        this.accountNumber = num;
    }

    void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber + "\nName: " + accountHolderName + "\nBalance: " + balance);
    }

    abstract double calculateInterest();

    final void generateStatement(){
        System.out.println("................Generating Statement..............");
        System.out.println("Account Number: " + accountNumber + "\nName: " + accountHolderName + "\nBalance: " + balance);
    }
}

class PremiumAccount2 extends Account2 implements TransactionService2{
    private double withdrawlLimit;

    PremiumAccount2(int num, String name, double bal, double lim){
        super(num, name, bal);
        this.withdrawlLimit = lim;
    }

    @Override
    double calculateInterest(){
        return balance*5/100;
    }

    @Override
    public void deposit(double m) throws Exception{
        if(m < 0){
            throw new Exception("Invalid Deposit");
        }
        else{
            balance += m;
            System.out.println("Deposit Successful" + "\nCurrent Account Balance: " + balance);
        }
    }

    @Override
    public void withdraw(double m) throws Exception{
        if(m > balance){
            throw new Exception("Invalid\nWithdrawl Exceeds Balance\nCurrent Account Balance: " + balance);
        }
        else if(m < 0){
            throw new Exception("Invalid Amount");
        }
        else if(balance - m < minBalance){
            throw new Exception("Invalid\nMinimum Balance: " + minBalance + "\nCurrent Account Balance: " + balance);
        }
        else{
            balance -= m;
            System.out.println("Withdrawl Successful\nCurrent Account Balance: " + balance);
        }
    }

    @Override
    void displayAccountDetails(){
        System.out.println("Account Number: " + accountNumber + "\nName: " + accountHolderName + "\nBalance: " + balance + "\nWithdrawl Limit: " + withdrawlLimit);
    }

    void storeInFile() {
        try {
            FileWriter f = new FileWriter("account.txt", true);
            f.write("Account Number: " + accountNumber + "\nHolder: " + accountHolderName + "\nBalance: " + balance);
            f.close();
            System.out.println("Account Data Stored in File");
        }
        catch(IOException e){
            System.out.println("File Error: " + e.getMessage());
        }
    }

    void readFile(){
        try{
            BufferedReader r = new BufferedReader(new FileReader("account.txt"));
            System.out.println("Reading File Data.........");
            String l;
            while((l = r.readLine()) != null){
                System.out.println(l);
            }
            r.close();
        }
        catch(IOException e){
            System.out.println("File Error: " + e.getMessage());
        }
    }
}

public class SBS2 {
    public static void main(String[] args){
        //Account2 a = new Account2(101, "Rahul2", 20000);
        Account2 b = new PremiumAccount2(2001, "Ananya", 50000, 100000);

        //a.displayAccountDetails();
        b.displayAccountDetails();

    }
}
