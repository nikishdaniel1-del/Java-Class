import java.util.*;
public class Task2 {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        String productsPrices = "\n";
        productsPrices += "=".repeat(8)+" Menu "+"=".repeat(8)+"\nid\titem\tprice";
        Object[][] items = {{1,"Soap",20.0},{2,"Chips",12.0},{3,"Oil",220.0},{4,"Rice",1500.0},{5,"Sugar",35.0}};
        for (int i=0;i<items.length;i++){productsPrices += "\n"+items[i][0]+"\t"+items[i][1]+"\t"+items[i][2];}
        productsPrices += "\n";
        int billNumber = 1;
        while (true) {
            int block = 0,qty=0;
            System.out.print("Enter 1.Take Orders , 2.Exit : ");
            String operation = terminal.next();
            if (operation.equals("2")){break;}
            else if(!operation.equals("1")){System.out.println("Invalid Operation.");}
            else{
            System.out.println(productsPrices);
            System.out.print("Enter the item's ID and it's quantity separated by ',' in format (id:qty) : ");
            String itemsInput = terminal.next();
            double discount=0,total = 0,price = 0;
            for (String item : itemsInput.split(",")){
                int id=0;
                if (!item.contains(":")){System.out.println("Invalid Input");block=1;}
                for (String splited : item.split(":")){
                    if (id==0){
                        try {id = Integer.parseInt(splited);
                        } catch (Exception e) {System.out.println("Invalid Input");block=1;}
                        if (block==1){continue;}
                        for (int x=0;x<items.length;x++){
                            int currentId = (int) items[x][0];
                            if (currentId==id){id=1;price = (double) items[x][2];break;}}}
                    else if(block==0){
                        try {qty = Integer.parseInt(splited);
                        } catch (Exception e){System.out.println("Invalid Input");block=1;}
                        if (block==1){continue;}
                        total += (double) qty*price;}}}
            if (block==1){continue;}
            System.out.println("\nBill : "+billNumber);
            System.out.println("Total Amount: "+total);
            if(total>3000){
                double rate = 0.1;
                if (total>5000){rate=0.2;}
                discount = total*rate;}
            System.out.println("Discount : "+discount);
            System.out.println("Discounted Total: "+(total-discount));
            billNumber++;}}}}