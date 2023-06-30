package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;
    int nwithdrawal;
    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
       super(name,balance,0);
       this.maxWithdrawalLimit=maxWithdrawalLimit;
       this.rate=rate;
       this.nwithdrawal=0;
    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
         if(this.nwithdrawal>=this.maxWithdrawalLimit){
             throw new RuntimeException("Maximum Withdraw Limit Exceed");
         }
         if(super.getBalance()<amount){
             throw new RuntimeException("Insufficient Balance");
         }
         double balancetoset=super.getBalance()-amount;
         super.setBalance(balancetoset);
         this.nwithdrawal+=1;
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
         double SI=super.getBalance()*this.rate*years;
         return SI;
    }
//FV = P*(1+R/N)^(N*T),
    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
          double CI=super.getBalance()*Math.pow((1+(this.rate/times)),times*years);
          return CI;
    }

}
