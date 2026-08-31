package week4;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FileOperation {
    public static void main(String[] args) {
        try {
            BufferedWriter cursor = new BufferedWriter(new FileWriter("Attendance.txt"));
            String[] nameList = {"1 Daniel 89 92 100 95 88","3 Kumar 78 88 90 78 77","2 John 88 76 98 99 92",
            "10 Matthew 89 98 99 97 93","11 Ram 78 87 89 98 76"};
            for (String name : nameList) {
                String design = "=".repeat(4);
                String[] currentDetails = name.split(" ");
                cursor.write(String.format("ID : %s\nName : %s\n%s Marks %s\n Tamil : %s\n English : %s\n Maths : %s\n Science : %s\n Social : %s\n",
                currentDetails[0],currentDetails[1],design,design,currentDetails[2],currentDetails[3],currentDetails[4],currentDetails[5],currentDetails[6]));
                cursor.newLine();}
            cursor.close();
        } catch (Exception e) {System.out.println(e.getMessage());}
        try {
            BufferedReader cursor = new BufferedReader(new FileReader("Attendance.txt"));
            String line;
            while ((line = cursor.readLine()) != null) System.err.println(line);
        } catch (Exception e) {System.out.println(e.getMessage());}}}