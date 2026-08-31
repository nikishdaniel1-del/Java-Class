package TasksADJ;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ReportGenerator implements Runnable {
    double totalSales, highestSales, lowestSales, averageSales;
    public ReportGenerator(double totalSales,double highestSales,double lowestSales,double averageSales) {
        this.totalSales = totalSales;
        this.highestSales = highestSales;
        this.lowestSales = lowestSales;
        this.averageSales = averageSales;
    }
    public void run() {
        System.out.println("Generating Report of "+Thread.currentThread().getName());
        System.out.println("=".repeat(15)+"Sales Report"+"=".repeat(15)+"\nTotal Sales : ₹"+totalSales+"\nHighest Sales : ₹"+highestSales+"\nLowest Sales : ₹"+lowestSales+"\nAverage Sales : ₹"+averageSales);
    }
}
class SalesCalculationTask implements Runnable {
    int rows;
    double totalSales, highestSales, lowestSales;
    ExecutorService executorService;
    SalesCalculationTask(int rows,double totalSales,double highestSales,double lowestSales,ExecutorService executorService) {
        this.rows = rows;
        this.totalSales = totalSales;
        this.highestSales = highestSales;
        this.lowestSales = lowestSales;
        this.executorService = executorService;
    }
    public void run() {
        System.out.println(Thread.currentThread().getName()+"'s Sales Calculating...");
        double averageSales = totalSales / rows;
        ReportGenerator report = new ReportGenerator(totalSales,highestSales,lowestSales,averageSales);
        executorService.execute(report);
    }
}

class FileProcessor implements Runnable {
    int rows;
    double price;
    double totalSales = 0;
    double highestSales = Double.MIN_VALUE;
    double lowestSales = Double.MAX_VALUE;
    String currentFile;
    ExecutorService executorService;
    FileProcessor(String currentFile,ExecutorService executorService) {
        this.currentFile = currentFile;
        this.executorService = executorService;
    }
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Reading the File : "+currentFile);
        try {
            BufferedReader cursor = new BufferedReader(new FileReader(currentFile));
            String line;
            while ((line = cursor.readLine()) != null) {
                rows++;
                price = Double.parseDouble(line);
                totalSales += price;
                if (price > highestSales) highestSales = price;
                if (price < lowestSales) lowestSales = price;
            }
            cursor.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        SalesCalculationTask sales = new SalesCalculationTask(rows,totalSales,highestSales,lowestSales,executorService);
        executorService.execute(sales);
    }
}
public class ParallelFileProcessing1 {
    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] files = {"salesJan.txt","salesFeb.txt","salesMar.txt"};
        for (String file : files) {
            executorService.execute(new FileProcessor(file, executorService));
        }
        Thread.sleep(2000);
        executorService.close();
    }
}