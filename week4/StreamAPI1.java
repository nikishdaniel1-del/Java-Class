package week4;
import java.util.*;

public class StreamAPI1 {
    public static void main(String[] args) {
        ArrayList<Integer> salary = new ArrayList<>();
        salary.add(19000);salary.add(25000);salary.add(39000);salary.add(35000);
        List<Integer> filteredSalary = salary.stream().filter(currentSalary -> currentSalary>=25000).toList();
        for (Integer salary1 : filteredSalary) {System.out.println(salary1);}}}