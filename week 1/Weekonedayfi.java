import java.util.*;
public class Weekonedayfi {
    public static void main(String[] args) {for (int i = 1; i <= 5; i++) {System.out.print("*");}
    String inputString = "";
    Scanner terminal=new Scanner(System.in);
    while (!inputString.equals("end")) {
        System.out.print("\nEnter the operation : ");
        inputString = terminal.next();
        System.out.print("Entered Operation is "+inputString);
    }
    inputString = "";
    System.out.print("\n");
    do {System.out.println("Alive");inputString=terminal.next();} while (!inputString.equals("."));
}
}