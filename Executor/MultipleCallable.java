package Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import Callables.PayRollExecutor;

class EmployeeProfile implements Callable<String>{
    public String call() throws 
}

public class MultipleCallable {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String> employee = executorService.submit()
        executorService.execute(new PayRollExecutor("Daniel", 20000.0));
        executorService.execute(new PayRollExecutor("Ram", 10000.0));
        executorService.execute(new PayRollExecutor("Ravi", 12000.0));
        executorService.execute(new PayRollExecutor("Kumar", 20000.0));
        executorService.shutdown();
    }
}