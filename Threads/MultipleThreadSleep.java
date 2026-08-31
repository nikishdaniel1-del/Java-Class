package Threads;

class Deposite extends Thread {
    public void run() {
        System.out.println("Deposite Starting...");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Deposite completed.");
    }
}

class WithDrawal extends Thread {
    public void run() {
        System.out.println("WithDraw Starting...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("WithDraw completed.");
    }
}

public class MultipleThreadSleep {
    public static void main(String[] args) {
        Deposite deposit = new Deposite();
        WithDrawal WithDrawal = new WithDrawal();

        deposit.start();
        WithDrawal.start();

        try {
            deposit.join();   // Wait for deposit thread
            WithDrawal.join();  // Wait for withdraw thread
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Completed.");
    }
}