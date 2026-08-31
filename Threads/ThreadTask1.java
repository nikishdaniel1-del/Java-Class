package Threads;
class Deposit implements Runnable{
    public void run(){System.out.println("Deposit Processing...");}}
class WithDraw implements Runnable{
    public void run(){System.out.println("WithDraw Processing...");}}
class Balance implements Runnable{
    public void run(){System.out.println("Fetching Balance...");}}
class MiniStatement implements Runnable{
    public void run(){System.out.println("Generating Mini-Statement...");}}
public class ThreadTask1 {
    public static void main(String args[]){
        Deposit deposite = new Deposit();
        WithDraw withDraw = new WithDraw();
        Balance balance = new Balance();
        MiniStatement miniStatement = new MiniStatement();
        Thread depositeThread = new Thread(deposite);
        Thread withDrawThread = new Thread(withDraw);
        Thread balanceThread = new Thread(balance);
        Thread miniStatementThread = new Thread(miniStatement);
        depositeThread.start();
        withDrawThread.start();
        balanceThread.start();
        miniStatementThread.start();}}