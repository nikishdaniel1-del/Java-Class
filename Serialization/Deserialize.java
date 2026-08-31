package Serialization;

import java.io.*;

public class Deserialize {
    public static void main(String[] args) throws Exception{
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("outputStream.ser"));
        Employee employee = (Employee) input.readObject();
        input.close();
        System.out.println("Employee Details : ");
        employee.display();
    }
}