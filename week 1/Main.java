import java.util.*;
//     public static void main(String[] args) {
//         System.out.println("Hello World");
//     }
// }


// public class Main {
//         public static void main(String[] args) {
//             int age = 22;
//             String name = "Nikish Daniel";
//             double salary = 20000.00;
//             System.out.println("Name : "+name);
//             System.out.println("Age : "+age);
//             System.out.println("Salary : "+salary);
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         Scanner input = new Scanner(System.in);
//         System.out.print("Enter Your Name : ");
//         String name = input.nextLine();
//         System.out.println("Hello "+name);
//     }
// }

public class Main {
    
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        System.out.print("Enter the Student's Name : ");
        String name = terminal.next();
        System.out.print("Enter Age : ");
        int age = terminal.nextInt();
        System.out.print("Enter Address : ");
        String address = terminal.next();
        System.out.print("Enter Department : ");
        String department = terminal.next();
        System.out.println("");
        System.out.println("Student's Details : ");
        System.out.println("Name - "+name+" ; Age - "+age+" ; Address - "+address+" ; Department - "+department);
        terminal.close();}}