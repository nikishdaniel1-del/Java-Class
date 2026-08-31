package TasksADJ;
import java.io.*;
import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Sensitive {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface DisplayName {
    String value();
}
class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    private String street;
    private String city;
    private String state;
    private String pincode;
    public Address(String street, String city, String state, String pincode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }
    @Override
    public String toString() {
        return street + ", " + city + ", " + state + " - " + pincode;
    }
}
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String department;
    @DisplayName("Employee Salary")
    private double salary;
    @Sensitive
    private transient String password;
    private Address address;
    public Employee(int id,String name,String department,double salary,String password,Address address) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.password = password;
        this.address = address;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "ID : " + id +"\nName : " + name +"\nDepartment : "+department+"\nSalary : "+salary+"\nPassword : "+password+"\nAddress : " + address;
    }
}
class EmployeeSerializer {
    public static void serialize(List<Employee> employees, String fileName) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName))) {
            output.writeObject(employees);
            System.out.println("Employee list serialized successfully.");
            System.out.println("File: " + fileName);
        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }
    }
}
class EmployeeDeserializer {
    @SuppressWarnings("unchecked")
    public static List<Employee> deserialize(String fileName) {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Employee> employees = (List<Employee>) input.readObject();
            System.out.println("Employee list deserialized successfully.");
            return employees;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization error: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
class EmployeeManager {
    private List<Employee> employees = new ArrayList<>();
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
    public List<Employee> getEmployees() {
        return employees;
    }
    public void saveEmployees(String fileName) {
        EmployeeSerializer.serialize(employees, fileName);
    }
    public void restoreEmployees(String fileName) {
        employees = EmployeeDeserializer.deserialize(fileName);
    }
    public void displayEmployees() {
        System.out.println("\n"+"=".repeat(7)+" RESTORED EMPLOYEES "+"=".repeat(7));
        for (Employee employee : employees) {
            System.out.println(employee+"\n"+"=".repeat(30));
        }
    }
}
class ReflectionUtility {
    public static void displaySensitiveFields(Class<?> clazz) {
        System.out.println("\n"+"=".repeat(7)+" Sensitive Fields "+"=".repeat(7));
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Sensitive.class)) {
                System.out.println(field.getName());
            }
        }
    }
    public static void displayAnnotatedValues(Object object) {
        System.out.println("\n"+"=".repeat(7)+" DisplayName Values "+"=".repeat(7));
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(DisplayName.class)) {
                DisplayName annotation = field.getAnnotation(DisplayName.class);
                try {
                    field.setAccessible(true);
                    Object value = field.get(object);
                    System.out.println(annotation.value() + " : " + value);
                } catch (IllegalAccessException e) {
                    System.out.println("Unable to access field: " + field.getName());
                }
            }
        }
    }
}
public class EmployeeApplication {
    public static void main(String[] args) {
        String fileName = "employees.ser";
        EmployeeManager manager = new EmployeeManager();
        Address address1 = new Address("10 MG Road","Chennai","Tamil Nadu","600001");
        Address address2 = new Address("25 Anna Nagar","Chennai","Tamil Nadu","600040");
        Address address3 = new Address("50 Park Street","Bengaluru","Karnataka","560001");
        Employee employee1 = new Employee(101,"Daniel","AI&DS",75000,"secret123",address1);
        Employee employee2 = new Employee(102,"Priya","HR",65000,"hr@123",address2);
        Employee employee3 = new Employee(103,"Rahul","Finance",85000,"finance@123",address3);
        manager.addEmployee(employee1);
        manager.addEmployee(employee2);
        manager.addEmployee(employee3);
        System.out.println("Employees before serialization:");
        manager.displayEmployees();
        ReflectionUtility.displaySensitiveFields(Employee.class);
        System.out.println("\n"+"=".repeat(7)+" SERIALIZATION "+"=".repeat(7));
        manager.saveEmployees(fileName);
        manager = new EmployeeManager();
        System.out.println("\nEmployees after clearing:");
        manager.displayEmployees();
        System.out.println("\n"+"=".repeat(7)+" DESERIALIZATION "+"=".repeat(7));
        manager.restoreEmployees(fileName);
        manager.displayEmployees();
        System.out.println(
                "\n"+"=".repeat(7)+" @DisplayName DEMONSTRATION "+"=".repeat(7));
        for (Employee employee : manager.getEmployees()) {
            ReflectionUtility.displayAnnotatedValues(employee);
        }
        System.out.println("\n"+"=".repeat(7)+" SENSITIVE DATA VERIFICATION "+"=".repeat(7));
        for (Employee employee : manager.getEmployees()) {
            if (employee.getPassword() == null) {
                System.out.println("Password is null after deserialization - NOT serialized.");
            } else {
                System.out.println("Password exists: " + employee.getPassword());
            }
        }
    }
}