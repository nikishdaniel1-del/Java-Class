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
@WebServlet("/viewPreference")
public class HRMSViewPreferenceServlet extends HttpServlet 
{
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException 
    {
        // Get existing session
        HttpSession session = request.getSession(false);
        if (session == null) 
        {
            response.sendRedirect("sessionLogin.html");
            return;
        }
        String employeeId = (String) session.getAttribute("employeeId");
        if (employeeId == null) 
        {
            response.sendRedirect("sessionLogin.html");
            return;
        }
        String language = null;
        String theme = null;
        String location = null;
        // Read cookies
        Cookie[] cookies = request.getCookies();
        if (cookies != null) 
        {
            for (Cookie cookie : cookies) 
            {
                if (cookie.getName().equals("language")) 
                {
                    language = cookie.getValue();
                }
 
                if (cookie.getName().equals("theme"))
                {
                    theme = cookie.getValue();
                }
 
                if (cookie.getName().equals("location")) 
                {
                    location = cookie.getValue();
                }
            }
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Saved Employee Preferences</h2>");
        out.println("Employee ID : " + employeeId + "<br>");
        out.println("Language : " + language + "<br>");
        out.println("Theme : " + theme + "<br>");
        out.println("Location : " + location + "<br>");
        out.println("</body></html>");
    }
}