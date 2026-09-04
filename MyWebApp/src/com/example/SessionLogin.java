package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class SessionLogin extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("HRMS Session Login Servlet Initialized");
    }

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String employeeId = request.getParameter("employeeId");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if ("1001".equals(employeeId) && "hrms123".equals(password)) {

            HttpSession session = request.getSession();

            session.setAttribute("employeeId", employeeId);

            out.println("<h2>Login Successful</h2>");
            out.println("<p>Employee ID : " + employeeId + "</p>");
            out.println("<p>Session Created Successfully</p>");
            out.println("<a href='dashboard'>Go to Dashboard</a>");

        } else {

            out.println("<h2>Login Failed</h2>");
            out.println("<p>Invalid Employee ID or Password</p>");
        }
    }

    @Override
    public void destroy() {
        System.out.println("HRMS Session Login Servlet Destroyed");
    }
}