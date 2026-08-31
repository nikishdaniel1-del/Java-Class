package Threads;
public class MakeThread extends Thread{
    public void run(){System.out.println("Employee Name : Nikish Daniel\nEmployee ID : 1");}
    public static void main(String[] args) {
        MakeThread threading = new MakeThread();
        threading.start();}}