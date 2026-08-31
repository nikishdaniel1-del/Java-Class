package Threads;

import Executor.PayRoll;

class PayRoll implements Runnable{
    public void run() {System.out.println("Payroll Processing...");
    }
}
class Attendance implements Runnable{
    public void run() {System.out.println("Attendance Processing...");
    }
}
class Email implements Runnable{
    public void run() {System.out.println("Email Notification Sent.");
    }
}
public class MultipleThreadRunnable {
    public static void main(String[] args) {
        PayRoll payRoll = new PayRoll();
        Attendance attendance = new Attendance();
        Email email = new Email();
        Thread pay = new Thread(payRoll);
        Thread attend = new Thread(attendance);
        Thread em = new Thread(email);
        pay.start();attend.start();em.start();
    }
}