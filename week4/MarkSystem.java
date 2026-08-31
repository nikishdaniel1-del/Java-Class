package week4;
import java.util.ArrayList;
import java.util.List;

public class MarkSystem {
    public static void main(String[] args) {
        ArrayList<Integer> stream = new ArrayList<>();
        stream.add(89);stream.add(88);stream.add(90);stream.add(78);
        System.out.println("Previous Mark List : "+stream);
        List<Integer> updatedStream = stream.stream().map(salary -> salary+5).toList();
        System.out.println("Updated Mark List : "+updatedStream);
        System.out.println("Sorted Mark List : "+updatedStream.stream().sorted().toList());}}