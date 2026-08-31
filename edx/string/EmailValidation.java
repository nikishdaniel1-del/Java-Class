package edx.string;

import java.util.Scanner;

public class EmailValidation {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        System.out.print("Enter the Email : ");
        String email = terminal.nextLine();
        char first = email.charAt(0);
        if (email.contains("@") && Character.isLetter(first) && email.endsWith(".com")) System.out.println("Valid");
        else System.out.println("Invalid");}}