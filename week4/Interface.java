package week4;

interface Greetings{
    void greets();}

class Greet implements Greetings{
    public void greets(){System.out.println("Hello Daniel");}}

public class Interface {
    public static void main(String[] args) {
        Greet obj = new Greet();
        obj.greets();}}