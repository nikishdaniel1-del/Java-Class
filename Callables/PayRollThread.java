package Callables;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Register implements Callable<String>{  
    public String call() throws Exception {
        Thread.sleep(2000);
        return "-".repeat(30)+"\nId : 1\nName : Nikish Daniel\nRole : Software Developer\nStatus : Active\n"+"-".repeat(30);
    }
}

class PayRoll implements Callable<String>{
    public String call() throws Exception {
        Thread.sleep(2500);
        return "-".repeat(30)+"\nId : 1\nBasic Salary : 20000.00\nHRA : 10000.00\nNet Salary : 3000.00\n"+"-".repeat(30);
    }
}

class Attendance implements Callable<String>{  
    public String call() throws Exception {
        Thread.sleep(3000);
        return "-".repeat(30)+"\nId : 1\nName : Nikish Daniel\nWorking Days : 27\nPresent : 25\nAbsent : 2\n"+"-".repeat(30);
    }
}

class Leave implements Callable<String>{  
    public String call() throws Exception {
        Thread.sleep(2500);
        return "-".repeat(30)+"\nId : 1\nName : Nikish Daniel\nCasual Leave : 1\nSick Leave : 1\nBalance Leave : 13\n"+"-".repeat(30);
    }
}

public class PayRollThread {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> report = executorService.submit(new Register());
        Future<String> payroll = executorService.submit(new PayRoll());
        Future<String> attendance = executorService.submit(new Attendance());
        Future<String> leave = executorService.submit(new Leave());
        System.out.println("Generating Report...\n" + report.get());
        System.out.println("Generating Payroll...\n" + payroll.get());
        System.out.println("Generating Attendance...\n" + attendance.get());
        System.out.println("Generating Leave...\n" + leave.get());
        executorService.shutdown();
    }
}