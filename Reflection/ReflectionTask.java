package Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTask {
    static class Customer{
        String name;
        public void display(){}
    }

    static class Amount{
        double amount;
        public void calculate(){}
    }

    static class Loan{
        double loanAmount;
        public void generate(){}
    }

    static class Transaction{
        double amount;
        public void showTransactions(){}
    }
    public static void main(String[] args) {
        Class<?>[] classes = ReflectionTask.class.getDeclaredClasses();
        for (Class<?> cclass : classes) {
            System.out.println("Class : "+cclass.getSimpleName());
            System.out.println("Fields : ");
            for (Field field : cclass.getDeclaredFields()) {
                System.out.println(" "+field.getName());
            }
            System.out.println("Methods : ");
            for (Method cmethod : cclass.getDeclaredMethods()){
                System.out.println(" "+cmethod.getName());
            }
            System.out.println("-".repeat(40));
        }
    }
}