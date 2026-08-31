package week3;
import java.util.*;

class Student {
    int rollNumber;
    String name;
    String department;
    Student(int rollNumber, String name, String department){
        this.rollNumber = rollNumber;
        this.name = name;
        this.department = department;}
    void displayDetails(){
        System.out.println("======= Student's Details =======");
        System.out.println("Roll Number : "+rollNumber);
        System.out.println("Name : "+name);
        System.out.println("Department : "+department);
        System.out.println("===================================");}}

public class WithObject {
    public static void main(String[] args) {
        ArrayListExample<Student> students = new ArrayListExample<>();
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
                students.add(new Student(rollNumber, name, department));}
            else if (operation == 2){
                System.out.print("Enter the roll number of the student to display details: ");
                int display = 0,id = terminal.nextInt();
                for (Student student : students){
                    if (student.rollNumber == id) {display = 1;student.displayDetails();break;}}
                if (display == 0){System.out.println("Student with roll number "+id+" not found!");}}
            else if (operation == 3){break;}
            else{System.out.println("Invalid operation! Please try again.");}}}}