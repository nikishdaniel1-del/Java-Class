package test.EmployeePayRollSystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Emp implements Comparable<Emp>{
    int id;String name,department,designation;double salary;
    Emp(int id,String name,String department,String designation,double salary){this.id=id;this.name=name;this.department=department;this.designation=designation;this.salary=salary;}
    public int compareTo(Emp other) {return this.name.compareToIgnoreCase(other.name);}}

public class EmployeeMain {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        outer:
        while (true){
            System.out.println("=".repeat(30)+"EMPLOYEE PAYROLL SYSTEM"+"=".repeat(30));
            System.out.println("1.Register Employee\n2.View All Employee\n3.Search Employee\n4.Update Employee Salary\n5.Delete Employee\n6.Sort by Name\n7.Sort by Salary\n8.Export to File\n9.Exit\n10.Search by Name");
            System.out.print("Enter Your Operation : ");
            int operation = terminal.nextInt();
            switch (operation) {
                case 1:
                    {System.out.print("Enter your Name : ");
                    String name = terminal.next();
                    if (Employee.checkName(name)==0) continue;
                    System.out.print("Enter your Department : ");
                    String department = terminal.next();
                    if (Employee.checkName(department)==0) continue;
                    System.out.print("Enter your Designation : ");
                    String designation = terminal.next();
                    if (Employee.checkName(designation)==0) continue;
                    System.out.print("Enter your Salary : ");
                    if (!terminal.hasNextDouble()){System.out.println("Invalid Salary Entry.");terminal.next();continue;}
                    double salary = terminal.nextDouble();
                    if (salary<0){salary=0.0;}
                    DBConnection.addData(name,department,designation,salary);break;}
                case 3:
                    {System.out.print("Enter the Employee ID : ");
                    int id = terminal.nextInt();
                    DBConnection.viewData(id);
                    break;}
                case 2:
                    {DBConnection.displayAll();
                    break;}
                case 4:
                    {System.out.print("Enter the Employee ID : ");
                    int id = terminal.nextInt();
                    System.out.print("Enter your Salary : ");
                    if (!terminal.hasNextDouble()){System.out.println("Invalid Salary Entry.");terminal.next();continue;}
                    double salary = terminal.nextDouble();
                    if (salary<0){salary=0;}
                    DBConnection.updateData(id,salary);
                    break;}
                case 5:{
                    System.out.print("Enter the Employee ID : ");
                    int id = terminal.nextInt();
                    DBConnection.delete(id);
                    break;}
                case 6:{
                    ArrayList<Emp> list = new ArrayList();
                    Connection connect = DBConnection.checkConnection();
                    if (connect != null) {
                        try {
                            Statement stmt = connect.createStatement();
                            ResultSet rs = stmt.executeQuery("SELECT * FROM employeetest");
                            while (rs.next()) {
                                list.add(new Emp(rs.getInt("empid"),rs.getString("empName"),rs.getString("department"),rs.getString("designation"),rs.getDouble("salary")));}
                            rs.close();stmt.close();connect.close();
                        } catch (SQLException e) {System.out.println(e.getMessage());}
                    } else {System.out.println("Database connection failed.");}
                    Collections.sort(list);
                    for (Emp emp : list){System.out.println(emp.id+" "+emp.name+" "+emp.department+" "+emp.designation+" "+emp.salary);}
                    break;}
                case 7:{
                    ArrayList<Emp> list = new ArrayList();
                    Connection connect = DBConnection.checkConnection();
                    if (connect != null) {
                        try {
                            Statement stmt = connect.createStatement();
                            ResultSet rs = stmt.executeQuery("SELECT * FROM employeetest");
                            while (rs.next()) {
                                list.add(new Emp(rs.getInt("empid"),rs.getString("empName"),rs.getString("department"),rs.getString("designation"),rs.getDouble("salary")));}
                            rs.close();stmt.close();connect.close();
                        } catch (SQLException e) {System.out.println(e.getMessage());}
                    } else {System.out.println("Database connection failed.");}
                    Collections.sort(list,(e1,e2) -> Double.compare(e1.salary, e2.salary));
                for (Emp emp : list) {System.out.println(emp.id+" "+emp.name+" "+emp.department+" "+emp.designation+" "+emp.salary);}
                break;}
                case 8:{
                    DBConnection.displayAll("1");
                    break;}
                case 9:{break outer;}
                case 10:{
                    System.out.print("Enter the Name : ");
                    String name = terminal.next();
                    DBConnection.viewData(name);break;}
                default:
{System.out.println("Invalid Operation.");}}}}}