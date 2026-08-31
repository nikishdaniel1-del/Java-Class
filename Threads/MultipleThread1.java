package Threads;
class AuthenticationThread extends Thread {
    public void run() {
        System.out.println("Authenticating Employee...");
    }
}
class AttendanceThreadDemo extends Thread {
    public void run() {
        System.out.println("Loading Attendance...");
    }
}
class EmailThread extends Thread {
    public void run() {
        System.out.println("Sending Welcome Email...");
    }
}
class SalaryThread extends Thread {
    public void run() {
        System.out.println("Sending Welcome Email...");
    }
}
public class MultipleThread1 {
    public static void main(String[] args) {
        AuthenticationThread auth = new AuthenticationThread();
        AttendanceThreadDemo attendance = new AttendanceThreadDemo();
        EmailThread email = new EmailThread();
        SalaryThread salary = new SalaryThread();
        auth.start();
        attendance.start();
        email.start();
        salary.start();}}