package Tasks;
import java.util.*;

public class StudentRegistration {
    public static void main(String[] args) {
        HashSet<String> stream = new HashSet<>();
        Scanner terminal = new Scanner(System.in);
        String result;
        while (true){
            System.out.print("Enter the 1.Add 2.Display 3.Remove 4.Check 5.Total 6.Exit : ");
            int operation = terminal.nextInt();
            if (operation==1){
                System.out.print("Enter the Name : ");
                String name = terminal.next().toLowerCase();
                result = "Student already exists.";
                if (!stream.contains(name)){
                    result = "Added Successfully!";
                    stream.add(name);}
                System.out.println(result);}
            else if (operation==2)System.out.println("=".repeat(25)+"\nRegistered Student's List : \n"+stream+"\n"+"=".repeat(25));
            else if (operation==3){
                System.out.print("Enter the Name : ");
                String name = terminal.next().toLowerCase();
                result = "Student doesn't exists.";
                if (stream.contains(name)){
                    stream.remove(name);
                    result = "Removed Successfully!";}
                System.out.println(result);}
            else if (operation==4){
                System.out.print("Enter the Name : ");
                String name = terminal.next().toLowerCase();
                result = "Student doesn't Exists.";
                if (stream.contains(name)){result = "Student Exists.";}
                System.out.println(result);}
            else if (operation==5)System.out.println("Total Registered : "+stream.size());
            else if (operation==6)break;
            else System.out.println("Invalid Operation.");}}}