package week2;

class EmpParent{
    int employeeId;String name;double salary;
    EmpParent(int id,String ename,double esalary){employeeId=id;name=ename;salary=esalary;}
    void display() {System.out.println("Employee ID: " + employeeId + "\nName: " + name + "\nSalary: " + salary);}}

class Developer1 extends EmpParent{
    String skill;
    Developer1(int id,String ename,double esalary,String skill){super(id,ename,esalary);this.skill=skill;}
    @Override
    void display() {System.out.println("Employee ID: " + employeeId + "\nName: " + name + "\nSalary: " + salary + "\nSkill: " + skill);}}

class Tester1 extends EmpParent{
    int projects;
    Tester1(int id,String ename,double esalary,int projects){super(id,ename,esalary);this.projects=projects;}
    @Override
    void display() {System.out.println("Employee ID: " + employeeId + "\nName: " + name + "\nSalary: " + salary + "\nProjects: " + projects);}}

public class MethodPloy {
    public static void main(String[] args) {
        // EmpParent emp = new EmpParent(1, "John", 50000);
        // emp.display();
        Developer1 dev = new Developer1(2, "Daniel", 20000, "Python Development");
        dev.display();
        Tester1 test = new Tester1(3, "Kumar", 15000, 5);
        test.display();}}