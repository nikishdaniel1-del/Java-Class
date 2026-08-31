package Tasks;
import java.util.*;

public class EPAS {
    public static void main(String[] args) {
        HashMap<String,Integer> stream = new LinkedHashMap<>();
        stream.put("Daniel",95);stream.put("Kumar",79);stream.put("Ram",80);
        stream.put("Ravi",91);stream.put("Kavin",86);stream.put("Ramu",70);
        stream.put("Rahul",92);stream.put("Ajay",79);stream.put("Sam",83);
        stream.put("Nikish",73);
        List<Map.Entry<String, Integer>> eligible = stream.entrySet().stream().filter(employee -> employee.getValue()>79).toList();
        System.out.println("Total Eligible Employees : "+eligible.size());
        System.out.println("First Eligible Employee : "+eligible.getFirst().getKey());
        System.out.println("Eligible Employees List : "+eligible);}}