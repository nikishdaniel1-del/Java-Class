package Reflection;

import java.lang.reflect.*;


class EmployeePrivate{
    private int id = 1;
    private String name = "Ravi";
    private double salary = 20000.00;
    public void display(){
        System.out.println("Employee Id : 1\nName : Nikish Daniel\nDepartment : Development");
    }
}

public class ReflectionAccess{
    public static void main(String[] args) throws Exception {
        EmployeePrivate emp = new EmployeePrivate();
        Field field = EmployeePrivate.class.getDeclaredField("name");
        field.setAccessible(true);
        System.out.println("Before Update : ");
        System.out.println("Employee Name : "+field.get(emp));
        field.set(emp,"Nikish Daniel");
        System.out.println("After Update : ");
        System.out.println("Employee Name : "+field.get(emp)+"\n");
        Method method = EmployeePrivate.class.getDeclaredMethod("display");
        method.invoke(emp);
    }
}