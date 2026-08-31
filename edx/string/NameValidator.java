package edx.string;
import java.util.Scanner;

public class NameValidator {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        System.out.println("Enter Your Name : ");
        String name = terminal.nextLine();
        name = name.trim().toLowerCase();
        System.out.println(Character.toUpperCase(name.charAt(0))+name.substring(1));}}