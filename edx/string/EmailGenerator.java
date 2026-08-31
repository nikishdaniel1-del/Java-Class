package edx.string;
import java.util.*;

public class EmailGenerator {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        System.out.print("Enter Your Name : ");
        String name = terminal.nextLine();
        System.out.println("Generated Email : "+name.trim().toLowerCase().replace(" ", ".")+"@company.com");}}