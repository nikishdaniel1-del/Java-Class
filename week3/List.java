package week3;

// public class List {
//     public static void main(String[] args) {
//         String[] names = new String[3];
//         names[0] = "Ram";
//         names[1] = "Ravi";
//         names[2] = "Priya";
//         // for (int i=0; i<names.length; i++){System.out.println(names[i]);}
//         for (String name : names){System.out.println(name);}}}

import java.util.*;
public class List {
    public static void main(String[] args) {
        ArrayListExample<String> names = new ArrayListExample<>();
        names.add("Ram");
        names.add("Ravi");
        names.add("Priya");
        // for (int i=0; i<names.size(); i++){System.out.println(names.get(i));}
        for (String name : names){System.out.println(name);}
        System.out.println();
        names.add("Vasu");
        for (String name : names){System.out.println(name);}}}