package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/dashboard")
public class HRMSDashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // Get existing session
        // false means: do not create a new session
        HttpSession session = request.getSession(false);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (session != null) {

            // Get Employee ID from Session
            String employeeId =
                    (String) session.getAttribute("employeeId");

            out.println("<h2>HRMS Employee Dashboard</h2>");
            out.println("<p>Welcome " + employeeId + "</p>");
            out.println("<p>Session is Active</p>");

        } else {

            out.println("<h2>Please Login First</h2>");
        }
    }
}