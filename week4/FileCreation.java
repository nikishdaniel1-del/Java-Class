package week4;
import java.io.FileWriter;

public class FileCreation {
    public static void main(String[] args) {
        try
        {
            FileWriter cursor = new FileWriter("data.txt");
            cursor.write("ID : 1\nName : Daniel\nSalary : 20000");
        cursor.close();}
        catch (Exception e){System.out.println(e.getMessage());}
    }}