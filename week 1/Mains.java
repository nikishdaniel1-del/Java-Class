import java.util.*;

public class Mains {
    public static void main(String[] args) {
        Scanner terminal=new Scanner(System.in);
        int balance = 10000,salary=800;
        String operation = "";
        while (true) {
            System.out.print("Opeartions :\n[1] Salary\n[2] Purchases \n[3] Show Balance\n[4] Exit \n\nEnter the Opeartion : ");
            operation = terminal.next();
            if (operation.equals("1")){
                System.out.print("Enter the no.of.working days : ");
                int days = terminal.nextInt();
                int salaryMonthly = salary*days;
                balance = balance+salaryMonthly;
                System.out.println("Salary : "+salaryMonthly+".\n");}
            else if(operation.equals("2")){
                int shirt = terminal.nextInt(),pant=terminal.nextInt();
                int totalCost = shirt+pant;
                if(balance>=totalCost){
                    balance = balance-totalCost;
                    System.out.println("Total Price : "+totalCost+".\n");}
                else{System.out.println("Not Enough Balance");}
            }
            else if(operation.equals("3")){System.out.println("Balance : "+balance+".\n");}
            else if(operation.equals("4")){System.out.println("Exit");break;}
            else{System.out.println("Invalid Entry.");}
        }
    }
}


// public class Mains {
//     public static void main(String[] args) {
//         System.out.println(300/3);
//         System.out.println(13%2);
//         int age = 18;
//         boolean id = true;
//         if (age>=18) {System.out.println("Eligible to vote");}
//         else{System.out.println("Not Eligible to vote");}
//         if (age>=18 && id) {System.out.println("Entry Allowed");}
//         else{System.out.println("Entry Denied");}
//     }}