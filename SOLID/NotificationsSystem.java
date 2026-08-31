package SOLID;

import java.util.ArrayList;

interface Observer{
    void notification(String message);
}
class EmployeeObserverDemo implements Observer{
    private String name;
    EmployeeObserverDemo(String name) {
        this.name = name;
    }
    public void notification(String message){
        System.out.println(name+" received : "+message);
    }
}
class Notifications{
    private ArrayList<Observer>stream = new ArrayList<>();
    public void addEmployee(Observer observer){
        stream.add(observer);
    }
    public void notify(String message){
        for (Observer current : stream) {
            current.notification(message);
        }
    }
}
public class NotificationsSystem {
    public static void main(String[] args) {
        Notifications notification = new Notifications();
        notification.addEmployee(new EmployeeObserverDemo("Daniel"));
        notification.addEmployee(new EmployeeObserverDemo("Anbu"));
        notification.notify("Leave Approved.");
    }
}