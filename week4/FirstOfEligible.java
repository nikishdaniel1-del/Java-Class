package week4;
import java.util.ArrayList;

public class FirstOfEligible {
    public static void main(String[] args) {
        ArrayList<Integer> stream = new ArrayList<>();
        stream.add(89);stream.add(88);stream.add(90);stream.add(78);
        System.out.println("First Eligible Employee score : "+stream.stream().filter(score -> score>80).findFirst().get());}}