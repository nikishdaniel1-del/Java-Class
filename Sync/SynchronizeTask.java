package Sync;
class BankAccount{
    int accountId;
    String accountHolder;
    double accountBalance;
    BankAccount(int accountId,String accountHolder,double accountBalance) {
        this.accountId = accountId;
        this.accountHolder = accountHolder;
        this.accountBalance = accountBalance;
    }
    public synchronized void updateBalance(String department, double amount){
        System.out.println(department + " started updating balance..");
        double temp = accountBalance;
        try
        {
            Thread.sleep( 1000);
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
        temp = temp + amount;
        accountBalance = temp;
        System.out.println(department +"Updated Balance : " +accountBalance );
    }
}

class Deposit extends Thread{
    BankAccount account;
    Deposit (BankAccount account){
        this.account=account;
    }
    public void run(){
        account.updateBalance("Deposit",3000);
    }
}

class WithDraw extends Thread{
    BankAccount account;
    WithDraw(BankAccount account){
        this.account=account;
    }
    public void run(){
        account.updateBalance("Withdraw",-1000);
    }
}

class Interest extends Thread{
    BankAccount account;
    Interest(BankAccount account){
        this.account=account;
    }
    public void run(){
        account.updateBalance("Interest",500);
    }
}

public class SynchronizeTask {
    public static void main(String[] args) throws InterruptedException{
        BankAccount account = new BankAccount(1,"Daniel",50000);
        Deposit deposit = new Deposit(account); 
        WithDraw withdraw = new WithDraw (account); 
        Interest interest = new Interest (account);
        deposit.start();
        withdraw.start();
        interest.start();
        deposit.join();
        withdraw.join();
        interest.join();
        System.out.println("-".repeat(30));
        System.out.println("Final Balance : " + account.accountBalance);
        System.out.println("-".repeat(30));
    }
}