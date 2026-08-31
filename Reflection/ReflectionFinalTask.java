package Reflection;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class EmployeeTasksFinal{
    private int id=1;
    private String name="Daniel",department="AI&DS",designation = "Software Engineer";
    public void displayEmployee(){
        System.out.println("-".repeat(30)+"\nEmployee Id : "+id+"\nEmployee Name : "+name+"\nDepartment : "+department+"\nDesignation : "+designation);
    }
}

public class ReflectionFinalTask {
    public static void main(String[] args) throws Exception {
        EmployeeTasksFinal employee = new EmployeeTasksFinal();
        System.out.println("-".repeat(30)+"\nProcessing...\n"+"-".repeat(30));
        Field currentFields = EmployeeTasksFinal.class.getDeclaredField("department");
        currentFields.setAccessible(true);
        System.out.println("Original Department : "+currentFields.get(employee));
        currentFields.set(employee, "IT");
        System.out.println("Updated Department : "+currentFields.get(employee));
        Field currentDesignation = EmployeeTasksFinal.class.getDeclaredField("designation");
        currentDesignation.setAccessible(true);
        System.out.println("Original Designation : "+currentDesignation.get(employee));
        currentDesignation.set(employee, "General Manager");
        System.out.println("Updated Designation : "+currentDesignation.get(employee));
        Method method = EmployeeTasksFinal.class.getDeclaredMethod("displayEmployee");
        method.invoke(employee);
    }
}