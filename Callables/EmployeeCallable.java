package Callables;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Profile implements Callable<String>{  
    public String call() throws Exception {
        Thread.sleep(2500);
        return "-".repeat(30)+"\nEmployee Id: 1\nName: Nikish Daniel\nDepartment: Software Development\nDesignation: Senior Java Developer\nEmail: nikish.daniel@company.com\n"+"-".repeat(30);
    }
}

class Projects implements Callable<String>{  
    public String call() throws Exception {
        Thread.sleep(2500);
        return "-".repeat(30)+"\nEmployee Id: 1\nActive Projects: 3\nCompleted Projects: 18\nCurrent Project: Employee Management System\nStatus: In Progress\n"+"-".repeat(30);
    }
}

class Training implements Callable<String>{  
    public String call() throws Exception {
        Thread.sleep(2500);
        return "-".repeat(30)+"\nEmployee Id: 1\nTrainings: Java Spring Boot, Docker Essentials, AWS Fundamentals\nCertification: Certified\n"+"-".repeat(30);
    }
}

class Assert implements Callable<String>{  
    public String call() throws Exception {
        Thread.sleep(2500);
        return "-".repeat(30)+"\nEmployee Id: 1\nLaptop: Dell Latitude 7440\nMonitor: Dell 24-inch\nAccess Card: Issued\nHeadset: Logitech H390\n"+"-".repeat(30);
    }
}

class Performance implements Callable<String>{  
    public String call() throws Exception {
        Thread.sleep(2500);
        return "-".repeat(30)+"\nEmployee Id: 1\nRating: 4.8/5\nAttendance: 98%\nTasks Completed: 126\nPromotion: Eligible\n"+"-".repeat(30);
    }
}

public class EmployeeCallable {
    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> profile = executorService.submit(new Profile());
        Future<String> projects = executorService.submit(new Projects());
        Future<String> training = executorService.submit(new Training());
        Future<String> asserts = executorService.submit(new Assert());
        Future<String> performance = executorService.submit(new Performance());
        System.out.println("Generating Profile...\n" + profile.get());
        System.out.println("Generating Projects...\n" + projects.get());
        System.out.println("Generating Training...\n" + training.get());
        System.out.println("Generating Assert...\n" + asserts.get());
        System.out.println("Generating Performance...\n" + performance.get());
        executorService.shutdown();
    }
}