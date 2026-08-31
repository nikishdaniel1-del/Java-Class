package TasksADJ;

import java.lang.reflect.*;

class Employee{
    private int id;
    private String name,department;
    private double salary;
    Employee() {
    }
    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    void getName(){
        System.out.println("Name : "+name);
    }
    void setName(String updatedName){
        name = updatedName;
    }
    void getSalary(){
        System.err.println("Salary"+salary);
    }
    void setSalary(double updatedSalary){
        salary = updatedSalary;
    }
    void displayDetails(){
        System.out.println("=".repeat(10)+" Employee Details "+"=".repeat(10)+"\nEmployee ID : "+id+"\nEmployee Name : "+name+"\nDepartment : "+department+"\nSalary : "+salary);
    }
}
public class ReflectionInspector {
    public static void main(String[] args) throws Exception {
        Employee employee1 = new Employee(1, "Raj", "AI&DS", 20000);
        Employee employee2 = new Employee(2, "Ram Kumar", "IT", 17000);
        System.out.println("=".repeat(15)+" Employee Fields "+"=".repeat(15));
        Field[] currentFields = Employee.class.getDeclaredFields();
        for (Field fields:currentFields){
            System.out.println("Field Name : "+fields.getName()+";   Data Type : "+fields.getType().getSimpleName());
        }
        System.out.println("=".repeat(15)+" Constructors "+"=".repeat(15));
        Constructor<?>[] constructors = Employee.class.getDeclaredConstructors();
        for (Constructor currentConstructor : constructors) {
            System.out.println("Constructor : "+currentConstructor.getName());
            System.out.println("=".repeat(7)+" Parameters "+"=".repeat(7));
            Class<?>[] parameters = currentConstructor.getParameterTypes();
            for (Object parameter : parameters) {
                System.out.println(parameter);
            }
            System.out.println("");
        }
        System.out.println("=".repeat(15)+" Methods "+"=".repeat(15));
        Method[] methods = Employee.class.getDeclaredMethods();
        for (Method currentMethod : methods){
            System.out.println(currentMethod.getName()+";   Return Type : "+currentMethod.getReturnType());
        }
        for (Field fields:currentFields){
            if (fields.getName().equals("name")){
                fields.setAccessible(true);
                System.out.println("=".repeat(8)+" Update Field values "+"=".repeat(8)+"\nBefore Update : \nEmployee Name : "+fields.get(employee1));
                fields.set(employee1,"Nikish Daniel");
                System.out.println("After Update : \nEmployee Name : "+fields.get(employee1));
            }
        }
        Method method = Employee.class.getDeclaredMethod("displayDetails");
        method.invoke(employee1);
    }
}