package Tasks;
import java.util.*;

class Student1 {
    String name;
    String department;
    Student1(String name, String department){
        this.name = name;
        this.department = department;}
    void displayDetails(){
        System.out.println("======= Student's Details =======");
        System.out.println("Name : "+name);
        System.out.println("Department : "+department);
        System.out.println("===================================");}}

public class WithHM {
    public static void main(String[] args) {
        HashMap<Integer, Student1> students = new HashMap<>();
        Scanner terminal = new Scanner(System.in);
        while (true){ 
            System.out.print("Enter the operation 1.add 2.display 3.exit: ");
            int operation = terminal.nextInt();
            if (operation == 1){
                System.out.print("Enter the roll number : ");
                int rollNumber = terminal.nextInt();
                System.out.print("Enter the name : ");
                String name = terminal.next();
                System.out.print("Enter the department : ");
                String department = terminal.next();
                students.put(rollNumber, new Student1(name, department));}
            else if (operation == 2){
                System.out.print("Enter the roll number of the student to display details: ");
                int id = terminal.nextInt();
                if (students.containsKey(id)) {students.get(id).displayDetails();}
                else{System.out.println("Student with roll number "+id+" not found!");}}
            else if (operation == 3){break;}
            else{System.out.println("Invalid operation! Please try again.");}}}}