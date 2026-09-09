package com.example;

public class EmployeeLeave {
    int employeeId;
    String leaveType;
    int dates;
    String reason;
    EmployeeLeave(int employeeId,String leaveType,int dates,String reason){
        this.employeeId=employeeId;
        this.leaveType=leaveType;
        this.dates=dates;
        this.reason=reason;
    }
    public int getEmployeeId(){
        return employeeId;
    }
    public String getLeaveType(){
        return leaveType;
    }
    public int getdates(){
        return dates;
    }
    public String getReason(){
        return reason;
    }
}