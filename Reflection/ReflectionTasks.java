package Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class EmployeeTasks{
    private int id=1;
    private String name="Daniel",department="AI&DS";
    public void displayEmployee(){
        System.out.println("\nEmployee Id : "+id+"\nEmployee Name : "+name+"\nDepartment : "+department);
    }
}

public class ReflectionTasks {
    public static void main(String[] args) throws Exception {
        EmployeeTasks employee = new EmployeeTasks();
        System.out.println("-".repeat(30)+"\nProcessing...\n"+"-".repeat(30));
        Field currentFields = EmployeeTasks.class.getDeclaredField("department");
        currentFields.setAccessible(true);
        System.out.println("Original Department : "+currentFields.get(employee));
        currentFields.set(employee, "IT");
        System.out.println("Updated Department : "+currentFields.get(employee));
        Method method = EmployeeTasks.class.getDeclaredMethod("displayEmployee");
        method.invoke(employee);
    }
}