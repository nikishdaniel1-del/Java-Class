package Serialization;

import java.io.*;

class Employee implements Serializable{
    private int id;
    private String name,department;
    private double salary;

    Employee(int id,String name,String department,double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    public void display(){
        System.out.println("Employee ID : "+id+"\nEmployee Name : "+name+"\nDepartment : "+department+"\nSalary : "+salary);
    }   
}

public class Serial {
    public static void main(String[] args) throws Exception{
        Employee employee = new Employee(1, "Nikish Daniel", "AI&DS", 20000);
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("outputStream.ser"));
        stream.writeObject(employee);
        stream.close();
        System.out.println("Employee Object Serialized.");
    }
}