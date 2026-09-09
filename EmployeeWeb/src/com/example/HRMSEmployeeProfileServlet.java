package com.example;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
 
@WebServlet("/employeeProfile")
public class HRMSEmployeeProfileServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException
    {
        System.out.println("Employee Profile Requested");
        Employee employee = new Employee("EMP1001","Nikish Daniel","AI&DS","AI Developer");
        String employeeId = employee.getEmployeeId();
        String employeeName = employee.getEmployeeName();
        String department = employee.getDepartment();
        String designation = employee.getDesignation();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Employee Profile</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>HRMS Employee Profile</h2>");
        out.println("<p>Employee ID : "+ employeeId + "</p>");
        out.println("<p>Employee Name : "+ employeeName + "</p>");
        out.println("<p>Department : "+ department + "</p>");
        out.println("<p>Designation : " + designation + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}