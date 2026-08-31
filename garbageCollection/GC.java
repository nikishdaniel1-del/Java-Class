package garbageCollection;

class Employee{int id=3;}

public class GC {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp = null;
        System.gc();
        System.out.println("Employee Object Eligible for Garbage collection.");}}