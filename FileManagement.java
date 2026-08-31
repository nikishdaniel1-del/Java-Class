import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class FileManagement {
    public static void main(String[] args){
        Scanner terminal = new Scanner(System.in);
        while (true){
            System.out.print("Enter the 1.Add 2.Display 3.Exit : ");
            int operation = terminal.nextInt();
            if (operation == 1){
                try{
                    FileWriter cursor = new FileWriter("data.txt",true);
                    System.out.print("Enter ID : ");
                    int id = terminal.nextInt();
                    System.out.print("Enter Name : ");
                    String name = terminal.next();
                    System.out.print("Enter Salary : ");
                    double salary = terminal.nextDouble();
                    cursor.write("ID : "+id+"\nName : "+name+"\nSalary : "+salary+'\n');
                    cursor.close();}
                catch (Exception e){System.out.println(e.getMessage());}}
            else if (operation==2){
                try{
                    FileReader cursor = new FileReader("data.txt");
                    int ch;
                    String result = "";
                    while ((ch = cursor.read()) != -1){
                        result = result + (char) ch;}
                    System.out.println(result);
                    cursor.close();}
                catch (Exception e){System.out.println(e.getMessage());}}
            else if (operation == 3)break;
            else System.out.println("Invalid Operation.");}}}