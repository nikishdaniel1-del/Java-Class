package Tasks;
import java.util.*;

class StudentR{
    String name;
    int age;
    StudentR(String name,int age){this.name = name;this.age = age;}
    void display(){System.out.print("\n"+"=".repeat(25)+"\nName : "+name+"\nAge : "+age+"\n"+"=".repeat(25)+"\n");}}

class InvalidAge extends Exception{
    InvalidAge(String message) {super(message);}}

public class StudentAdmissionsTask {
    public static void main(String[] args)
    {
        HashMap<String, StudentR> students = new HashMap<>();
        Scanner terminal = new Scanner(System.in);
        while (true){
            System.out.print("Enter the Operation 1.Add 2.Display 3.Exit : ");
            int operation = terminal.nextInt();
            if (operation == 1){
                System.out.print("Enter name : ");
                String name = terminal.next();
                System.out.print("Enter age : ");
                try {
                    int age = terminal.nextInt();
                    if (age<18){throw new InvalidAge("Age must be >= 18.");}
                    students.put(name,new StudentR(name,age));}
                catch (InvalidAge e){System.out.println(e.getMessage());}}
            else if (operation == 2){
                System.out.print("Enter name : ");
                String name = terminal.next();
                try {students.get(name).display();}
                catch (Exception e){System.out.println(e.getMessage());}
            }
            else if (operation == 3){break;}
            else{System.out.println("Invalid Operation.");}}}}