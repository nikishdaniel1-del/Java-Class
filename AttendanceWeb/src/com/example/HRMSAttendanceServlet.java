package com.example;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet ("/attendance")
public class HRMSAttendanceServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeAttendance employeeAttendance = new EmployeeAttendance("1001","Nikish Daniel","September",2026,21,2);
        request.setAttribute("attendance", employeeAttendance);
        request.getRequestDispatcher("employeeAttendance.jsp").forward(request,response);
    }
}