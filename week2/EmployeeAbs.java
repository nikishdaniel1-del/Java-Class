package week2;
abstract class AbstractEmployee {
    int id;
    String name;
    double salary;
    AbstractEmployee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;}
    void display(){System.out.println("ID: "+id+"\nName: "+name+"\nSalary: "+salary);}
    abstract void work();}
class Developer5 extends AbstractEmployee {
    Developer5(int id,String name,double salary){super(id,name,salary);}
    void work(){System.out.println("Developer is coding.");}}
public class EmployeeAbs {
    public static void main(String[] args) {
        Developer5 emp = new Developer5(1, "Daniel", 20000);
        emp.display();
        emp.work();}}