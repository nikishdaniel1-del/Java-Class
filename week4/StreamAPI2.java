package week4;
import java.util.HashMap;

public class StreamAPI2 {
    public static void main(String[] args) {
        HashMap<String,Integer> data = new HashMap<>();
        data.put("Daniel", 95);data.put("Ram", 72);data.put("Kumar", 90);
        data.put("Prawin", 88);data.put("Raj", 65);data.put("Kumaran", 95);
        data.put("David", 80);data.put("Raja", 91);data.put("Kavitha", 78);
        data.put("Navin", 86);data.put("Raman", 70);
        System.out.println("Employees eligible for Promotion : ");
        data.entrySet().stream().filter(entry -> entry.getValue() >= 80).forEach(entry -> System.out.println(entry.getKey()));}}