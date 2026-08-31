package Threads;

class Alive extends Thread {
    public void run() {
        System.out.println("Starting...");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Completed.");
    }
}

public class ThreadAlive {
    public static void main(String[] args) throws InterruptedException {
        Alive check = new Alive();
        System.out.println("Before Start : " + check.isAlive());
        check.start();
        Thread.sleep(500);
        System.out.println("After Start : " + check.isAlive());
        check.join();
        System.out.println("After Completed : " + check.isAlive());
        System.out.println("Main Completed");
    }
}