package SOLID;

import java.util.ArrayList;

interface receiveAttendance {
    void displayAttendance();
}
class EmployeeAttendance implements receiveAttendance {
    private String name, attendance;
    private static ArrayList<EmployeeAttendance> employeeList = new ArrayList<>();
    EmployeeAttendance(String name, String attendance) {
        this.name = name;
        this.attendance = attendance;
        employeeList.add(this);
    }
    public void displayAttendance() {
        for (EmployeeAttendance current : employeeList) {
            System.out.println(current.name + " - " + current.attendance);
        }
    }
}
class HRManager {
    private EmployeeAttendance employeeAttendance;
    private ArrayList<Integer> hrList = new ArrayList<>();
    public HRManager(EmployeeAttendance employeeAttendance) {
        this.employeeAttendance = employeeAttendance;
    }
    public void addHR() {
        hrList.add(1);
    }
    public void blockAccess(int hrID) {
        hrList.set(hrID, 0);
    }
    public void sendNotification() {
        int hrCount=0;
        for (int hr : hrList) {
            hrCount++;
            if (hr == 1) {
                System.out.println("HR "+hrCount+" Receives Attendance List : \n"+"=".repeat(30));
                employeeAttendance.displayAttendance();
                System.out.println("=".repeat(30));
            }
        }
    }
}
public class EmployeeAttendanceNotification {
    public static void main(String[] args) {
        EmployeeAttendance employee = new EmployeeAttendance("Daniel", "Present");
        new EmployeeAttendance("Ram", "Leave");
        new EmployeeAttendance("Kumar", "Late");
        HRManager hr = new HRManager(employee);
        hr.addHR();
        hr.addHR();
        hr.sendNotification();
        hr.addHR();
        hr.blockAccess(0);
        System.out.println("After the HR 1 blocked");
        hr.sendNotification();
    }
}