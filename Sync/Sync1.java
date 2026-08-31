package Sync;

class EmployeeSalary
{
    int empId;
    String empName;
    double salary;
    EmployeeSalary(int empId, String empName, double salary)
    {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }
    public synchronized void updateSalary(String department, double amount)
    {
    System.out.println(department + " started updating salary..");
    double temp = salary;
    try
    {
        Thread.sleep( 1000);
    }
    catch (InterruptedException e)
    {
        Thread.currentThread().interrupt();
    }
    temp = temp + amount;
    salary = temp;
    System.out.println(department +"Updated Salary : " +salary);
    }
}


class PayrollThreadRC extends Thread{
    EmployeeSalary employee;
    PayrollThreadRC (EmployeeSalary employee){
        this.employee=employee;
    }
    public void run(){
        employee.updateSalary("Payroll Team",3000);
    }
}
class AttendanceThreadRC extends Thread{
    EmployeeSalary employee;
    AttendanceThreadRC(EmployeeSalary employee){
        this.employee=employee;
    }
    public void run(){
        employee.updateSalary("Attendance Team",-1000);
    }
}
class FinanceThreadRC extends Thread{
    EmployeeSalary employee;
    FinanceThreadRC(EmployeeSalary employee){
        this.employee=employee;
    }
    public void run(){
        employee.updateSalary("Finance Team",500);
    }
}

public class Sync1{
    public static void main(String[] args) throws InterruptedException{
        EmployeeSalary employee = new EmployeeSalary(1,"Daniel",18000);
        PayrollThreadRC payroll = new PayrollThreadRC(employee); 
        AttendanceThreadRC attendance = new AttendanceThreadRC (employee); 
        FinanceThreadRC finance = new FinanceThreadRC (employee);
        payroll.start();
        attendance.start();
        finance.start();
        payroll.join();
        attendance.join();
        finance.join();
        System.out.println("-".repeat(30));
        System.out.println("Final Salary: " + employee.salary);
        System.out.println("-".repeat(30));
    }
}
