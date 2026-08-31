package week4;
import java.util.ArrayList;

public class LambdaObj {
    public static void main(String[] args) {
        ArrayList<String> stream = new ArrayList<>();
        stream.add("Daniel");stream.add("Jack");stream.add("John");stream.add("Kumar");
        System.out.println("Employee List : ");
        stream.forEach(System.out::println);}}