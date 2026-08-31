package week4;
interface Adds{int adding(int num1,int num2);}
public class Add {
    public static void main(String[] args) {
        Adds obj = (int num1,int num2) -> num1+num2;
        System.out.println("Total : "+obj.adding(20,30));}}