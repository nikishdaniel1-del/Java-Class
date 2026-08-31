package week2;
import java.util.*;

class Emp{
    static HashMap<Integer, List<Object>> employeeData = new HashMap<>();
    Emp(int id,String ename,double esalary){employeeData.put(id, Arrays.asList(ename,esalary));}
    static void showAll() {System.out.println(employeeData);}}

class Developer extends Emp{
    HashMap<Integer, List<Object>> developerData = new HashMap<>();
    Developer(int id,String ename,double esalary,String skills){super(id,ename,esalary);developerData.put(id, Arrays.asList(ename,skills));}
    void display() {System.out.println(developerData);}}
    
class Tester extends Emp{
    HashMap<Integer, List<Object>> testerData = new HashMap<>();
    Tester(int id,String ename,double esalary,int projects){super(id,ename,esalary);testerData.put(id, Arrays.asList(ename, projects));}
    void display() {System.out.println(testerData);}}

public class EmployeeInheritance {
    public static void main(String[] args) {
        Developer dev = new Developer(1, "Saravanan", 20000, "Python Development");
        dev.display();
        Tester test = new Tester(2, "Alice", 25000, 5);
        test.display();
        dev.showAll();}}