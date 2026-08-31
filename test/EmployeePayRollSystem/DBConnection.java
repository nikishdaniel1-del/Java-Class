package test.EmployeePayRollSystem;
import java.sql;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBConnection {

    public static Connection checkConnection(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javacls","root","Nikish@2003");
            return connection;
        } catch (Exception e) {return null;}
    }

    public static void addData(String name,String department,String designation,double salary){
        Connection connect = DBConnection.checkConnection();
        if (connect!=null){
            try{
            PreparedStatement ps = connect.prepareStatement("insert into employeetest(empName,department,designation,salary) values (?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, department);
            ps.setString(3, designation);
            ps.setDouble(4,salary);
            ps.executeUpdate();ps.close();connect.close();
            System.out.println("Added Successfully.");}
            catch (SQLException e) {System.out.println(e.getMessage());}}
        else System.out.println("DataBase Connection Fails");}

    public static void viewData(String name){
        Connection connect = DBConnection.checkConnection();
        if (connect != null) {
            try {
                PreparedStatement ps = connect.prepareStatement("SELECT * FROM employeetest WHERE empname = ?");
                ps.setString(1, name);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("empid"));
                    System.out.println("Name: " + rs.getString("empName"));
                    System.out.println("Department: " + rs.getString("department"));
                    System.out.println("Designation: " + rs.getString("designation"));
                    System.out.println("Salary: " + rs.getDouble("salary"));}
                rs.close();ps.close();connect.close();}
            catch (SQLException e) {System.out.println(e.getMessage());}}
        else System.out.println("DataBase Connection Fails");}

    public static void viewData(int id){
        Connection connect = DBConnection.checkConnection();
        if (connect != null) {
            try {
                PreparedStatement ps = connect.prepareStatement("SELECT * FROM employeetest WHERE empid = ?");
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    System.out.println("ID: " + rs.getInt("empid"));
                    System.out.println("Name: " + rs.getString("empName"));
                    System.out.println("Department: " + rs.getString("department"));
                    System.out.println("Designation: " + rs.getString("designation"));
                    System.out.println("Salary: " + rs.getDouble("salary"));}
                else {System.out.println("Employee Not Found");}
                rs.close();ps.close();connect.close();}
            catch (SQLException e) {System.out.println(e.getMessage());}}
        else System.out.println("DataBase Connection Fails");}

    public static void displayAll() {
        Connection connect = DBConnection.checkConnection();
        if (connect != null) {
            try {
                Statement stmt = connect.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM employeetest");
                while (rs.next()) {
                    System.out.println(rs.getInt("empid") + " " +rs.getString("empName") + " " +rs.getString("department") + " " +rs.getString("designation") + " " +rs.getDouble("salary"));}
                rs.close();stmt.close();connect.close();
            } catch (SQLException e) {System.out.println(e.getMessage());}
        } else {System.out.println("Database connection failed.");}}

    public static void displayAll(String file) {
        Connection connect = DBConnection.checkConnection();
        if (connect != null) {
            try {
                Statement stmt = connect.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM employeetest");
                FileWriter cursor = new FileWriter("data.txt");
                while (rs.next()) {
                    cursor.write(rs.getInt("empid") + " " +rs.getString("empName") + " " +rs.getString("department") + " " +rs.getString("designation") + " " +rs.getDouble("salary")+"\n");}
                cursor.close();rs.close();stmt.close();connect.close();
            } catch (Exception e) {System.out.println(e.getMessage());}
        } else {System.out.println("Database connection failed.");}}

    public static void updateData(int id,double newSalary){
    Connection connect = DBConnection.checkConnection();
        if (connect != null) {
            try {
            PreparedStatement cursor = connect.prepareStatement("UPDATE employeetest SET salary = ? where empID = ?");
            cursor.setDouble(1, newSalary);
            cursor.setInt(2, id);
            int result = cursor.executeUpdate();
            cursor.close();connect.close();
            if (result>0)System.out.println("Data updated successfully.");
            else System.out.println("No data found");}
            catch (Exception e) {System.out.println(e.getMessage());}}
        else System.out.println("DataBase Connection Fails");}

    public static void delete(int id){
        Connection connect = DBConnection.checkConnection();
        if (connect != null) {
            try{
            Scanner terminal = new Scanner(System.in);
            System.out.print("Are You Sure(Y/N) : ");
            String conf = terminal.next();
            if (conf.equals("Y")){
            PreparedStatement ps = connect.prepareStatement("DELETE FROM employeetest WHERE empID=?");
            ps.setInt(1, id);
            int result = ps.executeUpdate();ps.close();connect.close();
            if (result>0)System.out.println("Data deleted successfully.");
            else System.out.println("No data found");}}
            catch (Exception e) {System.out.println(e.getMessage());}}
        else System.out.println("DataBase Connection Fails");}
    public static void main(String[] args) {}}