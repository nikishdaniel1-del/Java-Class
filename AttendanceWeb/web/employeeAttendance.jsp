<%@ page import="com.example.EmployeeAttendance" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Attendance</title>
</head>
<body>
    <h2>HRMS Employee Attendance</h2>
    <% EmployeeAttendance attendance = (EmployeeAttendance)request.getAttribute("attendance"); %>
    <p>Employee ID: <%= attendance.getEmployeeId() %></p>
    <p>Employee Name: <%= attendance.getEmployeeName() %></p>
    <p>Designation: <%= attendance.getDesignation() %></p>
    <p>Month: <%= attendance.getMonth() %></p>
    <p>Year: <%= attendance.getYear() %></p>
    <p>Present Days: <%= attendance.getPresentDays() %></p>
    <p>Absent Days: <%= attendance.getAbsentDays() %></p>
</body>
</html>