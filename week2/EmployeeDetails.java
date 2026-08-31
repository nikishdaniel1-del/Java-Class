package week2;
class Employee{
    int employeeId;String name;double salary;
    void display() {System.out.println("Employee ID : "+employeeId+"\nName : "+name+"\nSalary : "+salary);}}
public class EmployeeDetails {
    public static void main(String[] args) {
        Employee employee1 = new Employee();
        employee1.employeeId = 2;employee1.name = "Daniel";employee1.salary = 20000.0;
        employee1.display();
        Employee employee2 = new Employee();
        employee2.employeeId = 1;employee2.name = "Nikish";employee2.salary = 18000.0;
        employee2.display();}}