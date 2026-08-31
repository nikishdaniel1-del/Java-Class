import java.util.*;
public class TaskDemo {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        String operation = "";
        while (true) {
            System.out.print("Enter the Operation (1:Calculate,2:Exit) : ");
            operation = terminal.next();
            if (operation.equals("2")){terminal.close();break;}
            else if (operation.equals("1")){
            System.out.println("======= Student's Report =======");
            System.out.print("Enter the Student's Roll Number : ");
            int rollNumber = terminal.nextInt();
            System.out.print("Enter Student's Name : ");
            String name = terminal.next();
            int total=0;
            double average;
            String grade,result="Pass";
            int index=1;
            while (index<4) {
                System.out.print("Subject "+index+" : ");
                int mark = terminal.nextInt();
                if (mark>-1 && mark<101){
                total += mark;
                index += 1;
                if (mark<35){result="Fail";}}
                else{System.out.println("Invalid Entry");}}
            System.out.println("Total : "+total);
            average = (double) total/(index-1);
            System.out.println("Average : "+average);
            if (average>=90){grade="A";}
            else if (average>=75){grade="B";}
            else if (average>=50){grade="C";}
            else{grade="D";}
            System.out.println("Grade : "+grade);
            System.out.println("Result : "+result);}
            else{System.out.println("Invalid Opeartion");}}}}