package week4;

interface EmployeeLam{void status();}

public class LambdaEmp {
    public static void main(String[] args) 
    {EmployeeLam emp = () -> System.out.println("Employee Completed the tasks.");
    emp.status();}}