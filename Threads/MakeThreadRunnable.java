package Threads;
class Emp implements Runnable{
    public void run(){System.out.println("Employee Name : Nikish Daniel\nEmployee ID : 1");}}

public class MakeThreadRunnable {
    public static void main(String[] args) {
        Emp threading = new Emp();
        Thread thread = new Thread(threading);
        thread.start();}}