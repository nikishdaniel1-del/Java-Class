package com.example;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/employeeLeaveRequest")
public class HRMSLeaveRequest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        System.out.println("Employee Profile Requested");
        EmployeeLeave EmployeeLeave = new EmployeeLeave(1,"Sick Leave",2,"Headache");
        String employeeId = String.valueOf(EmployeeLeave.getEmployeeId());
        String leaveType = EmployeeLeave.getLeaveType();
        String dates = String.valueOf(EmployeeLeave.getdates());
        String reason = EmployeeLeave.getReason();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Employee Leave Request</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>HRMS Employee Leave Request</h2>");
        out.println("<p>Employee ID : "+ employeeId + "</p>");
        out.println("<p>Leave Type : "+ leaveType + "</p>");
        out.println("<p>Dates : "+ dates + "</p>");
        out.println("<p>Reason : " + reason + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
