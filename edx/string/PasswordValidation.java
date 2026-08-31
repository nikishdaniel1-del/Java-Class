package edx.string;
import java.util.*;

public class PasswordValidation {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        System.out.print("Enter the Password : ");
        String password = terminal.next();
        int valid=0,total=0;
        for (char x : password.toCharArray()){
            if (Character.isLetterOrDigit(x)) valid++;
            total++;}
        if (valid==total && total==8)System.out.println("Valid Password.");
        else System.out.println("Invalid Password.");}}