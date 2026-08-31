package week3;
class InvalidSalary extends Exception{
    InvalidSalary(String message) {super(message);}}

public class ExceptionsCustom {
    static void validateSalary(double salary) throws InvalidSalary{
        if (salary<=0) {throw new InvalidSalary("Salary must be positive.");}}
    public static void main(String[] args) {
        try {validateSalary(-100);} 
        catch (InvalidSalary e) {System.out.println(e.getMessage());}}}