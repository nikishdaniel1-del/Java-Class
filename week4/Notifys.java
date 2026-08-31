package week4;

interface Notify{void sendMessage();}

public class Notifys {
    public static void main(String[] args) {
        Notify obj = () -> System.out.println("Message Sent Successfully");
        obj.sendMessage();}}