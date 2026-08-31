package week4;

import java.util.HashMap;

public class StreamAPI {
    public static void main(String[] args) {
        HashMap<String,Integer> data = new HashMap<>();
        data.put("Daniel", 85);data.put("Ram", 81);data.put("Kumar", 70);
        data.entrySet().stream().filter(entry -> entry.getValue() >= 80).forEach(System.out::println);
    }
}