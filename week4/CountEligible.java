package week4;
import java.util.ArrayList;

public class CountEligible {
    public static void main(String[] args) {
        ArrayList<Integer> stream = new ArrayList<>();
        stream.add(89);stream.add(88);stream.add(90);stream.add(78);
        System.out.println("Employees Eligible for Promotion : "+stream.stream().filter(score -> score>79).count());}}