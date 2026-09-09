package AttendanceWeb.src.com.example;

public class EmployeeAttendance {
    private String employeeId;
    private String employeeName;
    private String month;
    private int year;
    private int presentDays;
    private int absentDays;
    EmployeeAttendance(String employeeId, String employeeName, String month, int year, int presentDays, int absentDays) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.month = month;
        this.year = year;
        this.presentDays = presentDays;
        this.absentDays = absentDays;
    }
}