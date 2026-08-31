package Serialization;

import java.io.*;

class EmployeeTransient implements Serializable{
    private int id;
    private String name,department;
    private transient double salary;
    EmployeeTransient(int id,String name,String department,double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    public void display(){
        System.out.println("Employee ID : "+id+"\nEmployee Name : "+name+"\nDepartment : "+department+"\nSalary : "+salary);
    }   
}

public class TransientExample {
    public static void main(String[] args) throws Exception{
        EmployeeTransient employee = new EmployeeTransient(1, "Nikish Daniel", "AI&DS", 20000);
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("outputStream.ser"));
        stream.writeObject(employee);
        stream.close();
        System.out.println("Employee Object Serialized.");
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("outputStream.ser"));
        EmployeeTransient savedEmployee = (EmployeeTransient) input.readObject();
        input.close();
        System.out.println("-".repeat(30)+"\nEmployee Details : \n"+"-".repeat(30));
        savedEmployee.display();
    }
}