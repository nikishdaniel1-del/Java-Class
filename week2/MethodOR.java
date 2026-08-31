package week2;

class Empl{
    int eid;
    String name;
    double salary;
    Empl(int id,String ename,double esalary){eid=id;name=ename;salary=esalary;}
    void show() {System.out.println("Employee details\nID: " + eid + "\nName: " + name + "\nSalary: " + salary);}}
class Developer2 extends Empl{
    String skills;
    Developer2(int id,String ename,double esalary,String skill){super(id,ename,esalary);skills=skill;}
    void show() {System.out.println("Developer details\nID: " + eid + "\nName: " + name + "\nSalary: " + salary + "\nSkills: " + skills);}}
class Tester2 extends Empl{
    int projects;
    Tester2(int id,String ename,double esalary,int project){super(id,ename,esalary);projects=project;}
    void show() {System.out.println("Tester details\nID: " + eid + "\nName: " + name + "\nSalary: " + salary + "\nProjects: " + projects);}}
public class MethodOR {
    public static void main(String[] args) {
        Empl emp = new Empl(1, "John", 50000);
        emp.show();
        Developer2 dev = new Developer2(2, "Jane", 60000, "Java");
        dev.show();
        Tester2 test = new Tester2(3, "Bob", 55000, 5);
        test.show();}}