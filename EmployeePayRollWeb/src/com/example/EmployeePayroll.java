package com.example;

public class EmployeePayroll {
    private String employeeId;
    private String employeeName;
    private String month;
    private double basicSalary;
    private double allowances;
    private double deductions;
    public EmployeePayroll(String employeeId, String employeeName, String month, double basicSalary, double allowances, double deductions) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.month = month;
        this.basicSalary = basicSalary;
        this.allowances = allowances;
        this.deductions = deductions;
    }
    public String getEmployeeId() {
        return employeeId;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public String getMonth() {
        return month;
    }
    public double getBasicSalary() {
        return basicSalary;
    }
    public double getAllowances() {
        return allowances;
    }
    public double getDeductions() {
        return deductions;
    }
}