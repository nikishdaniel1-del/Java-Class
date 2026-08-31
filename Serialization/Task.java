package Serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

class EmployeeTransientTask implements Serializable{
    private int requestId,employeeId,numberOfDays;
    private String name,leaveType;
    private transient String status;
    EmployeeTransientTask(int requestId,int employeeId,String name,String leaveType,int numberOfDays,String status) {
        this.requestId = requestId;
        this.employeeId = employeeId;
        this.name = name;
        this.leaveType = leaveType;
        this.numberOfDays = numberOfDays;
        this.status = status;
    }
    public void display(){
        System.out.println("Request ID : "+requestId+"\nEmployee ID : "+employeeId+"\nEmployee Name : "+name+"\nLeave Type : "+leaveType+"\nNumber Of Days : "+numberOfDays+"\nStatus : "+status);
    }   
}
public class Task {
    public static void main(String[] args) throws Exception{
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("taskOutputStream.ser"));
        ArrayList<EmployeeTransientTask> employees = new ArrayList<>(
        Arrays.asList(
            new EmployeeTransientTask(1, 1, "Nikish Daniel", "Health Issues", 2, "Approved"),
            new EmployeeTransientTask(4, 2, "Ram", "Marriage", 1, "Pending"),
            new EmployeeTransientTask(5, 3, "Kumar", "Health Checkup", 1, "Approved")));
        for (EmployeeTransientTask current : employees) {
            stream.writeObject(current);
        }
        stream.close();
        System.out.println("Leave Requests Sent Successfully.");
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("taskOutputStream.ser"));
        for (int i = 0; i < 3; i++) {
            EmployeeTransientTask savedEmployee =(EmployeeTransientTask) input.readObject();
            System.out.println("-".repeat(30)+"\nEmployee Leave Details : \n"+"-".repeat(30));
            savedEmployee.display();
        }
        input.close();
    }
}