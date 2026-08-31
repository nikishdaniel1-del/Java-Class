package week4;
import java.util.ArrayList;

public class JMap {
    public static void main(String[] args) {
        ArrayList<Integer> stream = new ArrayList<>();
        stream.add(20000);stream.add(18000);stream.add(19000);stream.add(23000);
        System.out.println("Previous Salary List : "+stream);
        System.out.println("Updated Salary List : "+stream.stream().map(salary -> salary+5000).toList());}}