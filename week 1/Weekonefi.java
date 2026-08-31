import java.util.*;
public class Weekonefi {
    public static void main(String[] args) {
        int age = 17,balance=10000,withdraw=2000;
        // 1
        if (age>=18) {System.out.println("Eligible to vote");}
        else{System.out.println("Not Eligible to vote");}
        // 2
        if (balance>=withdraw){System.out.println("Balance : "+(balance-withdraw));}
        else{System.out.println("Insufficient Balance for Withdraw");}
        // 3
        Scanner terminal = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int number = terminal.nextInt();
        if (number%2==1){System.out.println("Odd");}
        else{System.out.println("Even");}
    }
}