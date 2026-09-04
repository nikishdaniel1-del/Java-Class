package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"/post", "/register"})
public class HRMSLoginServlet extends HttpServlet {
@Override
public void init() throws ServletException {
    System.out.println("HRMS Login Servlet Initialized");
}
@Override
protected void doPost(
        HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {
    String path = request.getServletPath(); 
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    if ("/post".equals(path)) {
        String employeeId = request.getParameter("employeeId");
        String password = request.getParameter("password");
        if ("EMP1001".equals(employeeId)
                && "hrms123".equals(password)) {
            out.println("<h2>Login Successful</h2>");
            out.println("<p>Welcome " + employeeId + "</p>");
        } else {
            out.println("<h2>Invalid Login</h2>");
            out.println("<p>Invalid Employee ID or Password</p>");
        }
    }
    else if ("/register".equals(path)) {
        String employeeId = request.getParameter("employeeId");
        String employeeName = request.getParameter("employeeName");
        String department = request.getParameter("department");
        String designation = request.getParameter("designation");
        out.println("<h2>Registration Successful</h2>");
        out.println("<p>Employee ID: " + employeeId + "</p>");
        out.println("<p>Employee Name: " + employeeName + "</p>");
        out.println("<p>Department: " + department + "</p>");
        out.println("<p>Designation: " + designation + "</p>");
    }
}
@Override
public void destroy() {
    System.out.println("HRMS Login Servlet Destroyed");
}
}