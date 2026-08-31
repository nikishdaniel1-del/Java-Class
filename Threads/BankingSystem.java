package Threads;
class DepositThread extends Thread {
    String rupee = "\u20B9";
    public void run() {System.out.println("Deposit : "+rupee+" 500 Successfully.");}}

class WithdrawThread extends Thread {
    String rupee = "\u20B9";
    public void run() {System.out.println("Withdraw : "+rupee+" 300 Successfully.");}}

class BalanceThread extends Thread {
    String rupee = "\u20B9";
    public void run() {System.out.println("Current Balance : "+rupee+" 8,200");}}

public class BankingSystem {
    public static void main(String[] args) {
        DepositThread deposit = new DepositThread();
        WithdrawThread withdraw = new WithdrawThread();
        BalanceThread balance = new BalanceThread();
        deposit.start();
        withdraw.start();
        balance.start();}}