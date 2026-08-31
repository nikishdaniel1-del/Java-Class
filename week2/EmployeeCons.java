package week2;
class Employe{
    int employeeId;String name;double salary;
    Employe(int id,String ename,double esalary){employeeId = id;name=ename;salary=esalary;}
    void display() {System.out.println("Employee ID : "+employeeId+"\nName : "+name+"\nSalary : "+salary);}}
public class EmployeeCons {
    public static void main(String[] args) {
        Employe emp1 = new Employe(1,"Daniel",20000);
        emp1.display();
        Employe emp2 = new Employe(3,"John",17000);
        emp2.display();}}