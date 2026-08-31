package Threads;
class Attributes extends Thread{
    public void run(){System.out.println("Thread Name : "+Thread.currentThread().getName());}
}

public class ThreadAttributes {
    public static void main(String[] args) {
        Attributes thread = new Attributes();
        thread.setName("my thread 1");
        thread.start();}}