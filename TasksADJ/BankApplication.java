package TasksADJ;

class BankAccount {
    String accountNumber;
    String accountHolder;
    double accountBalance;
    BankAccount(String accountNumber,String accountHolder,double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.accountBalance = accountBalance;
    }
    public synchronized boolean updateBalance(double amount,boolean increament){
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
        if (!increament && accountBalance<amount){
            Transactions.failed();
            return false;
        }
        if (increament) accountBalance = accountBalance+amount;
        else accountBalance = accountBalance-amount;
        System.out.println(Thread.currentThread().getName()+"'s Updated Balance : "+accountBalance);
        Transactions.success();
        return true;
    }
    public synchronized double getBalance(){
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
        return accountBalance;
    }
}
class Transfer extends Thread{
    BankAccount account1,account2;
    double amount;
    Transfer(BankAccount accountNumber1,BankAccount accountNumber2,double amount){
        this.account1 = accountNumber1;
        this.account2 = accountNumber2;
        this.amount = amount;
    }
    public synchronized void run(){
        System.out.println(Thread.currentThread().getName()+"'s Transfer Begin Progress...");
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
        if(account1.accountBalance<amount){
            Transactions.failed();
            System.out.println(Thread.currentThread().getName()+"'s Transfer Failed.Insufficient Balance.");
            return;
        }
        account1.accountBalance -= amount;
        account2.accountBalance += amount;
        Transactions.success();
        System.out.println(Thread.currentThread().getName()+"'s Transfer Successfull.");
    }
}
class Transactions implements Runnable{
    private static int success = 0;
    private static int failed = 0;
    String id,type;
    BankAccount currentAccount;
    double amount;
    Transactions(String id,BankAccount accountNumber,String type,double amount) {
        this.id = id;
        this.currentAccount = accountNumber;
        this.type = type;
        this.amount = amount;
    }
    public static synchronized void success() {
        success = success + 1;
    }
    public static synchronized void failed() {
        failed = failed + 1;
    }
    public static synchronized int getSuccess(){
        return success;
    }
    public static synchronized int getFailure(){
        return failed;
    }
    public void run(){
        System.out.println("Current Thread Name : "+Thread.currentThread().getName());
        if ("DEPOSIT".equalsIgnoreCase(type)){
            if (!currentAccount.updateBalance(amount,true)) System.out.println(Thread.currentThread().getName()+"'s Some Error happens Transaction Failed");
        }
        else if ("WITHDRAW".equalsIgnoreCase(type)) {
            if (!currentAccount.updateBalance(amount,false)) System.out.println(Thread.currentThread().getName()+"'s Not Sufficient Balance.Cancelling the Current Transaction...");
        }
    }
}
public class BankApplication{
    public static void main(String[] args) throws Exception{
        BankAccount user1 = new BankAccount("ACC101", "Nikish Daniel Y", 1000.56);
        BankAccount user2 = new BankAccount("ACC102", "HariRam S", 500.00);
        Thread t1 = new Thread(new Transactions("T001", user1, "Deposit", 10000.00));
        Thread t2 = new Thread(new Transactions("T002", user1, "Withdraw", 2500.00));
        Thread t3 = new Thread(new Transactions("T003", user2, "Deposit", 5000.00));
        Thread t4 = new Thread(new Transactions("T004", user2, "Withdraw", 6000.00));
        Thread t5 =  new Thread(new Transfer(user1,user2,2000.00));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        System.out.println("\n"+"=".repeat(30)+"\nTransaction Status :\nNumber of Successfull Transactions : "+Transactions.getSuccess()+"\nNumber of Failed Transactions : "+Transactions.getFailure());
        System.out.println("\n"+"=".repeat(30)+"\nFinal Balances : \nAccount ACC101 :\nBalance : "+user1.getBalance()+"\nAccount ACC102 :\nBalance : "+user2.getBalance()+"\n"+"=".repeat(30));
    }
}