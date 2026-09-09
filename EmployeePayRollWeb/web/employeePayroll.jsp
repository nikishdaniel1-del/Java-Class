<%@ page import="com.example.EmployeePayroll" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Payroll</title>
</head>
<body>
<h2>HRMS Employee Payroll</h2>
<% EmployeePayroll payroll = (EmployeePayroll)request.getAttribute("payroll"); %>
<p>
    Employee ID : <%= payroll.getEmployeeId() %>
</p>
<p>
    Employee Name : <%= payroll.getEmployeeName() %>
</p>
<p>
    Month : <%= payroll.getMonth() %>
</p>
<p>
    Basic Salary : <%= payroll.getBasicSalary() %>
</p>
<p>
    Allowances : <%= payroll.getAllowances() %>
</p>
<p>
    Deductions : <%= payroll.getDeductions() %>
</p>
</body>
</html>
 