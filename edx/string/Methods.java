package edx.string;
import java.util.*;

public class Methods {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        System.out.print("Enter the String : ");
        String sample = terminal.next();
        System.out.println("Length of the String : "+sample.length());
        System.out.print("Enter the index to return the Character : ");
        int index = terminal.nextInt();
        System.out.println("The character at index +"+index+" is : "+sample.charAt(index));
        System.out.print("Enter the check String : ");
        String sample1 = terminal.next();
        System.out.println("Equal check : "+sample.equals(sample1));
        System.err.println("Ignored case check : "+sample.equalsIgnoreCase(sample1));
        System.out.print("Enter the new String : ");
        terminal.nextLine();
        String sample2 = terminal.nextLine();
        sample2 = sample2.trim();
        System.out.println("Trimmed Sentence : "+sample2);
        System.out.println("Check input Contains 'is' : "+sample2.contains(sample2));
        System.out.println("Sub-String[3:9] : "+sample2.substring(3,9));
        sample2 = sample2.replace("Java", "Python");
        System.out.println("Replaced Word : "+sample2);
        System.out.println("Splitted Words : ");
        String[] stream = sample2.split(" ");
        for (String word : stream)System.out.println(word);
        System.out.println("UpperCase : "+sample2.toUpperCase());
        System.out.println("LowerCase : "+sample2.toLowerCase());
        System.out.println("Starts with 'Py' check : "+sample2.startsWith("Py"));
        System.out.println("Ends with 'resting' check : "+sample2.endsWith("resting"));}}