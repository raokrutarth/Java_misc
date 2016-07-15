import java.util.Scanner;
import  java.lang.Math;
import java.util.Random;
public class BankAccount
{
    private String name;
    private double balance;
    private int accNum;
    private static double interestRate = 0.3;
    private static int nAccounts;
    
    public BankAccount(String name)
    {
        this.name = name;
        this.balance = 0;
        this.accNum = accNumGenrator();
        nAccounts++;
    }
    public BankAccount(String name, double balance)
    {
        this(name);
        this.balance = balance;        
    }
    private int accNumGenrator()
    {
        Random r = new Random();
        int accNum = 100000 + r.nextInt(900000);
        return accNum;
    }
    public double deposit(double amount)
    {
        if (amount < 0)
        {
            return -1;
        }
        else
        {
            this.balance += amount;
            return amount;
        }
    }
    public double withdrawMoney(double amount)
    {
        if (amount < 0 || amount > this.balance)
        {
            return -1;
        }
        else
        {
            this.balance -= amount;
            return amount;
        }
    }
    public double getBalance()
    {
        return this.balance;
    }
    public int getAccountNumber()
    {
        return this.accNum;
    }
    public static double getInterestRate()
    {
        double rate = Math.round((interestRate - (nAccounts / 5) * 0.02) * 100) / 100.0;
        return rate;
    }
    public double transfer(BankAccount destinationBankAccount, double amount)
    {
        if (amount > this.balance || destinationBankAccount == null || amount < 0)
        {
            return -1;
        }
        else
        {
            this.withdrawMoney(amount);
            destinationBankAccount.deposit(amount);
            return amount;
        }
    }
    public double transfer(BankAccount[] destinationBankAccounts, double amount)
    {        
        if (amount < 0 || destinationBankAccounts == null || destinationBankAccounts.length == 0)
        {
            return -1;
        }
        else 
        {
            for ( BankAccount destAccount : destinationBankAccounts)
            {
                if (destAccount != null)
                {
                    double isSucessful = this.transfer(destAccount, amount);
                    if (isSucessful < 0)
                    {
                        return -1;
                    }
                }
                
            }
            return amount * destinationBankAccounts.length;
        }
    }
    public static void main(String[] args)
    {
        BankAccount bankAccount1 = new BankAccount("Bob", 544587000); 
        BankAccount bankAccount2 = new BankAccount("Cora");
        BankAccount bankAccount3 = new BankAccount("Piper");
        BankAccount bankAccount4 = new BankAccount("Clara", 547);
        BankAccount bankAccount5 = new BankAccount("Cadence");
        BankAccount bankAccount6 = new BankAccount("Skyler");
        BankAccount bankAccount7 = new BankAccount("Calle", 999999);
        BankAccount blankAcc = null;
        
        BankAccount[] accs = {blankAcc,blankAcc, bankAccount2, bankAccount3, bankAccount4, bankAccount5, bankAccount6}; 
        
        //BankAccount[] accs = null;
        
        double transfer = bankAccount1.transfer(accs, 50.0);
        double balance1 = bankAccount5.getBalance();
        System.out.println(transfer + " " +  balance1);
    }    
}
