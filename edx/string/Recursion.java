package edx.string;

import java.util.Scanner;

public class Recursion {
    static String recur(int n){
        if (n==1) return "Employee Number : 1";
        return "Employee Number : "+n+"\n"+recur(n-1);
    }
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        System.out.print("Enter the number of employees : ");
        int n = terminal.nextInt();
        System.out.println(recur(n));
    }
}
