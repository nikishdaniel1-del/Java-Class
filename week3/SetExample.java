package week3;

import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        HashSet<String> stream = new HashSet<>();
        Scanner terminal = new Scanner(System.in);
        while (true){
        System.out.print("Enter the 1.Add 2.Remove 3.Total Courses 4.Display 5.Exit : ");
        int operation = terminal.nextInt();
        if (operation == 1) {
            System.err.print("Enter the Course : ");
            stream.add(terminal.next().toLowerCase());
            System.out.println("Added Successfully!");}
        else if (operation==2){
            System.err.print("Enter the Course : ");
            stream.remove(terminal.next().toLowerCase());
            System.out.println("Removed Successfully!");}
        else if (operation==3)System.out.println("Total Courses : "+stream.size());
        else if (operation==4)System.out.println("Courses : "+stream);
        else if (operation==5)break;
        else System.out.println("Invalid Operation.");}}}