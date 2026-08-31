package week2;

class Emplo{
    void show() {System.out.println("Employee details:");}
    void show(int id,String name,double salary) {System.out.println("\nID: " + id + "\nName: " + name + "\nSalary: " + salary);}
    void show(int id,String name,double salary,String skills) {System.out.println("\nID: " + id + "\nName: " + name + "\nSalary: " + salary + "\nSkills: " + skills);}}

public class EmployeeOL {
    public static void main(String[] args) {
        Emplo emp = new Emplo();
        emp.show();
        emp.show(1, "Nikish", 50000);
        emp.show(2, "Daniel", 60000, "Python Development");}}