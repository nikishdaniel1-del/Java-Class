package week4;

interface Greets{
    void greetings();
}

public class LambdaC {
    public static void main(String[] args) {
        Greets greet = () -> System.out.println("Hello Daniel.");
        greet.greetings();}}