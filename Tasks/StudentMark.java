package Tasks;
import java.util.*;

public class StudentMark {
    public static void main(String[] args) {
        ArrayList<Double> stream = new ArrayList<>();
        Scanner terminal = new Scanner(System.in);
        while (true){
            System.out.print("Enter the operation 1.add marks 2.total&avg 3.min&max 4.exit : ");
            int operation = terminal.nextInt();
            if (operation==1){
                stream.clear();
                System.out.print("Enter the marks separated by ',' : ");
                for (String mark:terminal.next().split(","))stream.add(Double.parseDouble(mark));}
            else if (operation==2){
                double total=0;
                for (Double marks:stream)total = total+marks;
                System.out.println("=".repeat(25)+"\nTotal : "+total);
                System.out.println("Average : "+(double) total/stream.size()+"\n"+"=".repeat(25));}
            else if (operation==3){
                System.out.println("=".repeat(25)+"\nMaximum Mark : "+Collections.max(stream));
                System.out.println("Minimum Mark : "+Collections.min(stream)+"\n"+"=".repeat(25));}
            else if (operation==4)break;
            else System.out.println("Invalid Operation.");}}}