package Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Employee{
    int id;
    String name,department;
    double salary;
    public void calculate(){

    }
    public void display(){

    }
}

public class Reflection {
    public static void main(String[] args) {
        Employee emp = new Employee();
        Class<Employee> cls = Employee.class;
        for (Field field : cls.getDeclaredFields()) {
            System.out.println(field.getName());
        }
        for (Method method :cls.getDeclaredMethods()) {
            System.out.println(method.getName());
        }
    }
}