package Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class DepositExe implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Deposit Processing !");
    }
}

class WithDrawExe implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " WithDraw Processing !");
    }
}

class BalanceExe implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Balance Processing !");
    }
}

class MiniStatement implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Mini-Statement Processing !");
    }
}

public class BankingExecutor {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new DepositExe());
        executorService.execute(new WithDrawExe());
        executorService.execute(new BalanceExe());
        executorService.execute(new MiniStatement());
        executorService.shutdown();
    }
}