package edx.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Employee implements Comparable<Employee>{
    int id;String name;

    Employee(int id, String name) {this.id = id;this.name = name;}
    @Override
    public  int compareTo(Employee ids){return this.id-ids.id;}
    
}

public class ComparableS {
    public static void main(String[] args) {
        ArrayList<Employee> emp = new ArrayList<>();
        emp.add(new Employee(2,"Daniel"));
        emp.add(new Employee(1,"Nikish"));
        Collections.sort(emp,new Comparator<Employee>(){public int compare(Employee e1,Employee e2){return e1.name.compareTo(e2.name);}});
        for (Employee empl : emp) System.out.println(empl.id+" "+empl.name);}}