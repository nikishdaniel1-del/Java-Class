package Tasks;
import java.util.*;

abstract class LibraryItem {
    static HashMap<Integer, List<Object>> items = new HashMap<>();
    private int id;
    private String name;
    private double price;
    LibraryItem(int id, String name, double price,String type){
        this.id = id;
        this.name = name;
        this.price = price;
        if (!items.containsKey(id)){items.put(id,Arrays.asList(name,price,type));}}

    static void getData(String type,Scanner terminal){
        System.out.print("Enter ID : ");
        int id = terminal.nextInt();
        System.out.print("Enter Name : ");
        String name = terminal.next();
        System.out.print("Enter Price : ");
        double price = terminal.nextDouble();
        if (type.equals("1")){LibraryBook obj=new LibraryBook(id,name,price);obj.issueItem();}
        else if (type.equals("2")){LibraryMagazine obj=new LibraryMagazine(id,name,price);obj.issueItem();}}

    static void modifyData(String type,Scanner terminal){
        System.out.print("Enter the Item id : ");
        int id = terminal.nextInt();
        if (!LibraryItem.items.containsKey(id)){System.out.println("Item not found.");return;}
        if (type.contains("1")){
            if (!items.get(id).get(2).equals("book")){System.out.println("Item is not a book.");return;}
            LibraryBook obj1 = new LibraryBook(id, "type", 0);
            System.out.print("Enter the option to modify (1.Name , 2.Price , 3.Both) : ");
            String option = terminal.next();
            if (option.equals("1")){
                System.out.print("Enter the Name : ");
                String name = terminal.next();
                obj1.issueItem(id,name);}
            else if (option.equals("2")){
                System.out.print("Enter the Price : ");
                double price = terminal.nextDouble();
                obj1.issueItem(id,price);}
            else if (option.equals("3")){
                System.out.print("Enter the Name : ");
                String name = terminal.next();
                System.out.print("Enter the Price : ");
                double price = terminal.nextDouble();
                obj1.issueItem(id,name,price);}
            else{System.out.println("Invalid option.");}}
        else{
            if (!items.get(id).get(2).equals("magazine")){System.out.println("Item is not a magazine.");return;}
            LibraryMagazine obj1 = new LibraryMagazine(id, "type", 0);
            System.out.print("Enter the option to modify (1.Name , 2.Price , 3.Both) : ");
            String option = terminal.next();
            if (option.equals("1")){
                System.out.print("Enter the Name : ");
                String name = terminal.next();
                obj1.issueItem(id,name);}
            else if (option.equals("2")){
                System.out.print("Enter the Price : ");
                double price = terminal.nextDouble();
                obj1.issueItem(id,price);}
            else if (option.equals("3")){
                System.out.print("Enter the Name : ");
                String name = terminal.next();
                System.out.print("Enter the Price : ");
                double price = terminal.nextDouble();
                obj1.issueItem(id,name,price);}
            else{System.out.println("Invalid option.");}}}

    static void searchData(Scanner terminal){
        System.out.print("Enter the Item id : ");
        int id = terminal.nextInt();
        if (LibraryItem.items.containsKey(id)){
            System.out.println("Item found: ");
            System.out.println("-".repeat(20));
            System.out.println("Name : " + items.get(id).get(0));
            System.out.println("Price : " + items.get(id).get(1));
            System.out.println("-".repeat(20));}
        else{System.out.println("Item not found.");}}

    void setPrice(int cid){
        if ((Double) items.get(cid).get(1)<0){items.get(cid).set(1, 0.0);}}

    void setPrice(double price){
        if (price>0) {items.get(id).set(1, price);}}}

class LibraryBook extends LibraryItem{
    int id;
    LibraryBook(int id, String name, double price){super(id,name,price,"book");this.id = id;}
    void issueItem(){setPrice(id);System.out.println("-".repeat(20));System.out.println(items.get(id).get(0)+" Book Issued!!");System.out.println("-".repeat(20));}
    void issueItem(int id, String name){System.out.println("-".repeat(20));items.get(id).set(0, name);System.out.println(name + " Book Issued!!");System.out.println("-".repeat(20));}
    void issueItem(int id, double price){setPrice(price);System.out.println("-".repeat(20));System.out.println(items.get(id).get(0) + " Book Issued!!");System.out.println("-".repeat(20));}
    void issueItem(int id, String name, double price){
        items.get(id).set(0, name);
        setPrice(price);
        System.out.println("-".repeat(20));System.out.println(name + " Book Issued!!");System.out.println("-".repeat(20));}}

class LibraryMagazine extends LibraryItem{
    int id;
    LibraryMagazine(int id, String name, double price){super(id,name,price,"magazine");this.id = id;}
    void issueItem(){setPrice(id);System.out.println("-".repeat(20));System.out.println(items.get(id).get(0)+" Magazine Issued!!");System.out.println("-".repeat(20));}
    void issueItem(int id, String name){System.out.println("-".repeat(20));items.get(id).set(0, name);System.out.println(name + " Magazine Issued!!");System.out.println("-".repeat(20));}
    void issueItem(int id, double price){
        setPrice(price);
        System.out.println("-".repeat(20));System.out.println(items.get(id).get(0) + " Magazine Issued!!");System.out.println("-".repeat(20));}
    void issueItem(int id, String name, double price){
        items.get(id).set(0, name);
        setPrice(price);
        System.out.println("-".repeat(20));System.out.println(name + " Magazine Issued!!");System.out.println("-".repeat(20));}}

public class Library {
    
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        String operation="";
        while (true){
        System.out.print("Enter your Operation (1.Add Book ,2.Add Magazine ,3.Modify Book ,4.Modify Magazine ,5.Search ,6.Exit) : ");
        operation = terminal.next();
        if (operation.equals("1")){LibraryItem.getData("1",terminal);}
        else if (operation.equals("2")){LibraryItem.getData("2",terminal);}
        else if (operation.equals("3")){LibraryItem.modifyData("1",terminal);}
        else if (operation.equals("4")){LibraryItem.modifyData("2",terminal);}
        else if (operation.equals("5")){LibraryItem.searchData(terminal);}
        else if (operation.equals("6")){break;}
        else{System.out.println("Invalid Operation");}}}}