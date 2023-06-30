package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name,double balance) {
        this.name = name;
        this.balance=balance;
    }

    public BankAccount(String name, double balance, double minBalance) {
         this.name=name;
         this.balance=balance;
         this.minBalance=minBalance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
       if(sum<0 || sum>9*digits){
           throw new RuntimeException("Account Number can not be generated");
       }
        int remaining=sum;
        String ac="";
        for(int i=0;i<=digits;i++){
            int digi=Math.min(9,remaining);
            ac+=digi;
            remaining-=digi;
        }
        return ac;
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance+=amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
         if(amount>this.balance || this.balance-amount<this.minBalance){
             throw new RuntimeException("Insufficient Balance");
         }
         this.balance-=amount;
    }

}