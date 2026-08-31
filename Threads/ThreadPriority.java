package Threads;
class Priority extends Thread{
    public void run(){System.out.println(Thread.currentThread().getPriority());}}

public class ThreadPriority {
    public static void main(String args[]){
        Priority thread = new Priority();
        thread.setPriority(1);
        thread.start();}}