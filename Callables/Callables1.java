package Callables;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Report implements Callable<String>{
    public String call() throws Exception {
        Thread.sleep(2000);
        return "Id : 1\nName : Nikish Daniel\nRole : Software Developer";
    }
}

public class Callables1 {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> holder = executorService.submit(new Report());
        System.out.println("Generating...\n"+holder.get());
        executorService.shutdown();
    }
}