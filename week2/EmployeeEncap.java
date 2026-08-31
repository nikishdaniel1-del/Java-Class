package week2;

class EmployeeEncapu{
    private int id;
    private String name,skills;
    private double salary;
    EmployeeEncapu(int id, String name, double salary, String skills){
        this.id = id;
        this.name = name;
        setSalary(salary);
        this.skills = skills;}
    void setSalary(double salary) {
        if (salary > 0) {this.salary = salary;}
        else {System.out.println("Invalid salary.");}}
    void getSalary() {System.out.println("Salary: " + salary);}
    void display() {
        System.out.println("ID: " + id + "\nName: " + name + "\nSkills: " + skills);
        getSalary();}}

public class EmployeeEncap {
    public static void main(String[] args) {
        EmployeeEncapu emp1 = new EmployeeEncapu(1, "Daniel", 50000, "Python Development");
        emp1.display();
        emp1.getSalary();}}