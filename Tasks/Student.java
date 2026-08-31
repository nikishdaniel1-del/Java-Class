package Tasks;
import java.util.*;

class Student1 {
    int rollNumber;
    String name;
    String department;
    Student1(int rollNumber, String name, String department){
        this.rollNumber = rollNumber;
        this.name = name;
        this.department = department;}
    void displayDetails(){
        System.out.println("======= Student's Details =======");
        System.out.println("Roll Number : "+rollNumber);
        System.out.println("Name : "+name);
        System.out.println("Department : "+department);
        System.out.println("===================================");}}

public class Student {
    public static void main(String[] args) {
        HashMap<Integer, Student1> studentsRecord = new HashMap<>();
        while (true){
            Scanner terminal = new Scanner(System.in);
            System.out.print("Enter the operation 1.add 2.display 3.Search 4.Remove 5.exit: ");
            int operation = terminal.nextInt();
            if (operation == 1){
                System.out.print("Enter the roll number : ");
                int rollNumber = terminal.nextInt();
                System.out.print("Enter the name : ");
                String name = terminal.next();
                System.out.print("Enter the department : ");
                String department = terminal.next();
                studentsRecord.put(rollNumber,new Student1(rollNumber,name,department));}
            else if (operation == 2){
                System.out.print("Enter the roll number of the student to display details: ");
                int id = terminal.nextInt();
                if (studentsRecord.containsKey(id)) {studentsRecord.get(id).displayDetails();}
                else{System.out.println("Student with roll number "+id+" not found!");}}
            else if (operation == 3){
                System.out.print("Enter the roll number of the student to search: ");
                int id = terminal.nextInt();
                if (studentsRecord.containsKey(id)) {System.out.println("Student with roll number "+id+" found!");}
                else{System.out.println("Student with roll number "+id+" not found!");}}
            else if (operation == 4){
                System.out.print("Enter the roll number of the student to remove: ");
                int id = terminal.nextInt();
                if (studentsRecord.containsKey(id)) {
                    studentsRecord.remove(id);
                    System.out.println("Student with roll number "+id+" removed successfully!");}
                else {System.out.println("Student with roll number "+id+" not found!");}}
            else if (operation == 5){break;}
            else{System.out.println("Invalid operation! Please try again.");}}}}