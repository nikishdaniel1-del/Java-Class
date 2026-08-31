import java.sql.*;
import java.util.*;

public class MYsql {
    static Scanner terminal = new Scanner(System.in);
    public static void main(String[] args) {
        while (true){
        System.out.print("Enter the Operation (1.Add Data 2.Display Data 3.Modify Data 4.Delete 5.Display Table 6.Exit): ");
        int operation = terminal.nextInt();
        if (operation == 1)addData();
        else if (operation == 2)display();
        else if (operation == 3)modifyData();
        else if (operation == 4)deleteData();
        else if (operation == 5)displayTable();
        else if (operation == 6)break;
        else{System.out.println("Invalid Operation.");}}}
        public static int addData(){try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javacls","root","Nikish@2003");
            PreparedStatement ps = connection.prepareStatement("insert into employee(empName,salary) values (?,?)");
            System.out.print("Enter the Employee's Name : ");
            String name = terminal.next();
            String numeric = "0123456789";
            for (char i : numeric.toCharArray()){
                if (name.contains(String.valueOf(i))){System.out.println("Invalid Name Entry.");return 0;}}
            System.out.print("Enter the Employee's Salary : ");
            if (!terminal.hasNextDouble()){System.out.println("Invalid Salary Entry.");terminal.next();return 0;}
            double salary = terminal.nextDouble();
            if (salary<0)salary = 0;
            ps.setString(1, name);
            ps.setDouble(2, salary);
            ps.executeUpdate();ps.close();connection.close();
            System.out.println("Added successfully.");
            return 1;
        } catch (Exception e) {System.out.println(e.getMessage());return 0;}}
        public static void displayTable() {
            try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javacls","root","Nikish@2003");
            Statement cursor = connection.createStatement();
            System.out.println("Table Data : \n"+"=".repeat(35));
            ResultSet data = cursor.executeQuery("SELECT * FROM employee");
            while (data.next()){System.out.println(data.getInt("empID")+" - "+data.getString("empName")+" - "+data.getDouble("salary"));}
            data.close();cursor.close();connection.close();
            System.out.println("=".repeat(35));}
            catch (Exception e) {System.out.println(e.getMessage());}}
        public static void display() {
            try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javacls","root","Nikish@2003");
            System.out.print("Enter the Id : ");
            int id = terminal.nextInt();
            PreparedStatement ps = connection.prepareStatement("select * FROM employee WHERE empID=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Employee ID : " + rs.getInt("empID"));
                System.out.println("Name        : " + rs.getString("empName"));
                System.out.println("Salary      : " + rs.getDouble("salary"));} 
            else System.out.println("Employee not found.");
            ps.close();connection.close();}
            catch (Exception e) {System.out.println(e.getMessage());}}
        public static int modifyData(){
            System.out.print("Enter the Employee ID to modify : ");
            int id = terminal.nextInt();
            System.out.print("Enter the new salary : ");
            if (!terminal.hasNextDouble()){System.out.println("Invalid Salary Entry.");terminal.next();return 0;}
            double newSalary = terminal.nextDouble();
            if (newSalary<0)newSalary = 0;
            try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javacls","root","Nikish@2003");
            PreparedStatement cursor = connection.prepareStatement("UPDATE employee SET salary = ? where empID = ?");
            cursor.setDouble(1, newSalary);
            cursor.setInt(2, id);
            int result = cursor.executeUpdate();
            cursor.close();connection.close();
            if (result>0)System.out.println("Data updated successfully.");
            else System.out.println("No data found");
            return 1;}
            catch (Exception e) {System.out.println(e.getMessage());return 0;}}
        public static void deleteData(){
            System.out.print("Enter the Employee ID to delete : ");
            int id = terminal.nextInt();
            try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javacls","root","Nikish@2003");
            PreparedStatement ps = connection.prepareStatement("DELETE FROM employee WHERE empID=?");
            ps.setInt(1, id);
            int result = ps.executeUpdate();ps.close();connection.close();
            if (result>0)System.out.println("Data deleted successfully.");
            else System.out.println("No data found");}
            catch (Exception e) {System.out.println(e.getMessage());}}}