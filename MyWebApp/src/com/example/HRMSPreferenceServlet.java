package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/savePreference")
public class HRMSPreferenceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("sessionLogin");
            return;
        }
        String employeeId = (String) session.getAttribute("employeeId");
        if (employeeId == null) {
            response.sendRedirect("sessionLogin.html");
            return;
        }
        String language = request.getParameter("language");
        String theme = request.getParameter("theme");
        String location = request.getParameter("location");
        Cookie languageCookie = new Cookie("language", language);
        Cookie themeCookie = new Cookie("theme", theme);
        Cookie locationCookie = new Cookie("location", location);
        languageCookie.setMaxAge(60 * 60 * 24);
        themeCookie.setMaxAge(60 * 60 * 24);
        locationCookie.setMaxAge(60 * 60 * 24);
        response.addCookie(languageCookie);
        response.addCookie(themeCookie);
        response.addCookie(locationCookie);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>HRMS Employee Preferences</h2>");
        out.println("Employee ID : " + employeeId + "<br>");
        out.println("Language : " + language + "<br>");
        out.println("Theme : " + theme + "<br>");
        out.println("Location : " + location + "<br>");
        out.println("<h3>Preferences Saved Successfully!</h3>");
        out.println("<a href='viewPreference'>");
        out.println("View Saved Preferences");
        out.println("</a>");
        out.println("</body></html>");
    }
}