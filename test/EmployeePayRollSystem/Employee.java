package test.EmployeePayRollSystem;

public class Employee {
    public static int checkName(String name) {
        String numbers = "1234567890";
        for (char i : numbers.toCharArray()){
            if (name.contains(String.valueOf(i))){System.out.println("Invalid Name Entry.");return 0;}}
        return 1;}
    public static void main(String[] args) {
    }
}