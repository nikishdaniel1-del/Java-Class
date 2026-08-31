package Threads;
class EmployeeRegister extends Thread{
    public void run(){
        for (int i=0;i<4;i++){System.out.println("Registering...");}
    }
}
class EmployeePayroll extends Thread{
    public void run(){
        for (int i=0;i<4;i++){System.out.println("Payroll processing...");}
    }
}
class EmployeeAttendace extends Thread{
    public void run(){
        for (int i=0;i<4;i++){System.out.println("Registering...");}
    }
}
public class MultipleThread {
    public static void main(String[] args) {
        EmployeeRegister hr = new EmployeeRegister();
        EmployeePayroll payroll = new EmployeePayroll();
        EmployeeAttendace attendace = new EmployeeAttendace();
        hr.start();
        payroll.start();
        attendace.start();}}