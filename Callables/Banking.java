package Callables;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Account implements Callable<String>{  
    public String call() throws Exception {
        Thread.sleep(2500);
        return "-".repeat(30)+"\nAccount Id : 1\nHolder Name : Nikish Daniel\nBalance : 20000.00\n"+"-".repeat(30);
    }
}

class Deposit implements Callable<String>{  
    public String call() throws Exception {
        Thread.sleep(2500);
        return "-".repeat(30)+"\nAccount Id : 1\nHolder Name : Nikish Daniel\nDeposit : 2000.00\nBalance : 22000.00\n"+"-".repeat(30);
    }
}

class WithDrawal implements Callable<String>{  
    public String call() throws Exception {
        Thread.sleep(2500);
        return "-".repeat(30)+"\nAccount Id : 1\nHolder Name : Nikish Daniel\nWithdrawal : 1000.00\nBalance : 21000.00\n"+"-".repeat(30);
    }
}

class Loan implements Callable<String>{  
    public String call() throws Exception {
        Thread.sleep(2500);
        return "-".repeat(30)+"\nAccount Id : 1\nHolder Name : Nikish Daniel\nLoan Amount : 10000.00\nInterest Rate : 5.0%\n"+"-".repeat(30);
    }
}

public class Banking {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> account = executorService.submit(new Account());
        Future<String> deposit = executorService.submit(new Deposit());
        Future<String> withdraw = executorService.submit(new WithDrawal());
        Future<String> loan = executorService.submit(new Loan());
        System.out.println("Generating account...\n" + account.get());
        System.out.println("Generating deposit...\n" + deposit.get());
        System.out.println("Generating withdraw...\n" + withdraw.get());
        System.out.println("Generating loan...\n" + loan.get());
        executorService.shutdown();
    }
}