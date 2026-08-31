package TasksADJ;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class SalesResult {
    int numberOfRecords;
    double totalSales;
    double highestSale;
    double lowestSale;
    double averageSale;
    public SalesResult(int numberOfRecords,double totalSales,double highestSale,double lowestSale,double averageSale) {
        this.numberOfRecords = numberOfRecords;
        this.totalSales = totalSales;
        this.highestSale = highestSale;
        this.lowestSale = lowestSale;
        this.averageSale = averageSale;
    }
}

public class ParallelProcessing2 {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] files = {"salesJan.txt","salesFeb.txt","salesMar.txt"};
        List<Future<SalesResult>> futures = new ArrayList<>();
        for (String file : files) {
            Callable<SalesResult> task = () -> {
                int rows=0;
                double totalSales = 0;
                double highestSales = Double.MIN_VALUE;
                double lowestSales = Double.MAX_VALUE;
                try (BufferedReader cursor = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = cursor.readLine()) != null) {
                        rows++;
                        double price = Double.parseDouble(line);
                        totalSales += price;
                        if (price > highestSales) highestSales = price;
                        if (price < lowestSales) lowestSales = price;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                return new SalesResult(rows,totalSales,highestSales,lowestSales,totalSales/rows);
            };
            Future<SalesResult> future = executorService.submit(task);
            futures.add(future);
        }
        for (Future<SalesResult> futureData : futures) {
            SalesResult result = futureData.get();
            System.out.println("=".repeat(15)+"Sales Report"+"=".repeat(15));
            System.out.println(
                "Number of Rows : "+result.numberOfRecords+"\nTotal Sales : "+result.totalSales+"\nHighest Sale : "+result.highestSale
                +"\nLowest Sale : "+result.lowestSale+"\nAverage Sale : "+result.averageSale);
        }
        executorService.shutdown();
    }
}