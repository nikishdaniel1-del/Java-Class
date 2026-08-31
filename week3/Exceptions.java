package week3;

public class Exceptions {
    public static void main(String[] args) {
        try {
            int salary=-100;
            if (salary<0){throw new ArithmeticException("Salary must be positive.");}
            salary = salary/0;
            salary = Integer.parseInt("abd");
        }
        catch (NumberFormatException s){System.out.println("Invalid type conversion.");}
        catch (ArithmeticException y){System.out.println(y.getMessage());}
        catch (Exception e){System.out.println("Invalid salary assignation.");}
        finally{System.out.println("Program Executed Successfully.");}}}