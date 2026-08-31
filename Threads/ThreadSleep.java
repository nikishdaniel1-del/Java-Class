package Threads;
class Sleep extends Thread{
    public void run(){
        try {
            System.out.println("Processing..");
            Thread.sleep(3000);
            System.out.println("Done");
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
        }
}

public class ThreadSleep {
    public static void main(String[] args) {
        Sleep thread = new Sleep();
        thread.start();
    }
}
