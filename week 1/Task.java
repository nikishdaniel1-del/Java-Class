import java.util.*;

public class Task {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        String operation = "";
        int[][] db = new int[60][4];
        int index = 0;
        while (true) {
            System.out.print("Enter the operation (1:Add Data,2:Show Data,3:Exit) : ");
            operation = terminal.next();
            if (operation.equals("1")){
                if (index>60){System.out.println("Limit Exceeds.");}
                else{
                System.out.print("Enter the Student's Roll Number : ");
                int rollNumber = terminal.nextInt();
                System.out.print("Enter the Student's Name : ");
                String name = terminal.next();
                int total = 0, status = 1;
                for (int i = 1;i<=3;i++){
                    System.out.print("Subject "+i+" : ");
                    int mark = terminal.nextInt();
                    total += mark;
                    if (mark<35){status=0;}}
                db[index++] = new int[]{rollNumber, total, (total * 100) / 300, status};}}
            else if(operation.equals("2")){
                System.out.println("==== Student's Report ===");
                System.out.print("Enter the Student's Roll Number : ");
                int studentNumber = terminal.nextInt();
                for (int i=0;i<=index;i++){
                    int id = db[i][0],average = db[i][2],resultStatus = db[i][3];
                    if (id!=0 && id == studentNumber){
                    String grade="",result = "Pass";
                    if (average>=90){grade="A";}
                    else if (average>=75){grade="B";}
                    else if (average>=50){grade="C";}
                    else{grade="D";}
                    if (resultStatus==0){result="Fail";}
                    System.out.print("Total : "+db[i][1]+"\nAverage : "+average);
                    System.out.println("\nGrade : "+grade+"\nResult : "+result);}}}
            else if(operation.equals("3")){break;}
            else{System.out.println("Invalid Operation");}}}}