package edx.string;
import java.util.Scanner;

public class Split {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        System.out.print("Enter the String : ");
        for (String word : terminal.nextLine().split(",")){System.out.println(word);}}}