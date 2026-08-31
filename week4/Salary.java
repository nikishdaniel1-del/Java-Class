package week4;

interface SalaryUp{double add(double salary,double increament);}

public class Salary {
    public static void main(String[] args) {
        SalaryUp obj = (double salary,double increament) -> salary+increament;
        System.out.println("Net Salary : "+obj.add(20000, 2000));}}