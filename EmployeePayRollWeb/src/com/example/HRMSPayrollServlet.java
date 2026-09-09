package com.example;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet ("/payroll")
public class HRMSPayrollServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeePayroll employeePayroll = new EmployeePayroll("1001", "Nikish Daniel", "September", 18000.0, 1000.0, 1000.0);
        request.setAttribute("payroll", employeePayroll);
        request.getRequestDispatcher("employeePayroll.jsp").forward(request, response);
    }
}