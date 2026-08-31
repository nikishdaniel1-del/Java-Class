package Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Employees{
    int id;
    String name,department;
    double salary;
    public void Account(){

    }
    public void Loan(){

    }
    public void Transactions(){

    }
}

public class Reflection1 {
    public static void main(String[] args) {
        Class<Employees> cls = Employees.class;
        System.out.println("Fields : ");
        for (Field field : cls.getDeclaredFields()) {
            System.out.println(" "+field.getName());
        }
        System.out.println("Methods : ");
        for (Method method :cls.getDeclaredMethods()) {
            System.out.println(" "+method.getName());
        }
    }
}