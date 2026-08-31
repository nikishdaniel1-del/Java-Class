package Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Registration implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + "Registration Processing !");
    }
}

class PayRoll implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + "PayRoll Processing !");
    }
}

class Attendance implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + "Attendance Processing !");
    }
}

class EmailNotification implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + "EmailNotification Processing !");
    }
}

public class Executor {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(new Registration());
        executorService.execute(new PayRoll());
        executorService.execute(new Attendance());
        executorService.execute(new EmailNotification());
        executorService.shutdown();
    }
}