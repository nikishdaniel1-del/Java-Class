package week3;
import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<Integer> stream = new ArrayList<>();
        stream.add(89);stream.add(79);stream.add(80);stream.add(86);
        // System.out.println("Student's Marks : ");
        int total = 0;
        for (Integer mark:stream)total = total+mark;
        System.out.println("Total Marks : "+total);
        System.out.println("Average Marks : "+(double) total/stream.size());}}