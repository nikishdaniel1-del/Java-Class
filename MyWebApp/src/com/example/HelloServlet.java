package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/Railway.html")
               .forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("login".equals(action)) {
            String userId = request.getParameter("userId");
            String password = request.getParameter("password");
            if ("P1001".equals(userId) && "rail123".equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("userId", userId);
                showTrainPage(response, session);
            } else {
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<h2>Login Failed</h2>");
                out.println("<p>Invalid User ID or Password</p>");
                out.println("<a href='hello'>Try Again</a>");
            }
        }
        else if ("train".equals(action)) {
            HttpSession session = request.getSession(false);
            if (session == null) {
                showLoginMessage(response);
                return;
            }
            String train = request.getParameter("train");
            session.setAttribute("train", train);
            showSeatPage(response, session);
        }
        else if ("seat".equals(action)) {
            HttpSession session = request.getSession(false);
            if (session == null) {
                showLoginMessage(response);
                return;
            }
            String seat = request.getParameter("seat");
            session.setAttribute("seat", seat);
            showConfirmation(response, session);
        }
        else if ("logout".equals(action)) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h2>Logout Successful</h2>");
            out.println("<p>Session Destroyed Successfully</p>");
            out.println("<br>");
            out.println("<a href='hello'>Login Again</a>");
        }
    }
    private void showTrainPage(HttpServletResponse response,
                               HttpSession session)
            throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String userId = (String) session.getAttribute("userId");
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Railway Reservation</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Railway Reservation System</h1>");
        out.println("<h2>Welcome " + userId + "</h2>");
        out.println("<h2>Select a Train</h2>");
        out.println("<form action='hello' method='post'>");
        out.println("<input type='hidden' name='action' value='train'>");
        out.println("<input type='radio' name='train' ");
        out.println("value='Vaigai Superfast Express' required>");
        out.println("Vaigai Superfast Express");
        out.println("<br><br>");
        out.println("<input type='radio' name='train' ");
        out.println("value='Nellai Superfast Express'>");
        out.println("Nellai Superfast Express");
        out.println("<br><br>");
        out.println("<input type='radio' name='train' ");
        out.println("value='Vande Bharat Express'>");
        out.println("Vande Bharat Express");
        out.println("<br><br>");
        out.println("<input type='submit' value='Select Train'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
    private void showSeatPage(HttpServletResponse response,
                              HttpSession session)
            throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String train = (String) session.getAttribute("train");
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Select Coach</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Railway Reservation System</h1>");
        out.println("<h2>Selected Train: " + train + "</h2>");
        out.println("<h2>Select a Coach</h2>");
        out.println("<form action='hello' method='post'>");
        out.println("<input type='hidden' name='action' value='seat'>");
        out.println("<input type='radio' name='seat' ");
        out.println("value='AC Chair Car' required>");
        out.println("CC");
        out.println("<br><br>");
        out.println("<input type='radio' name='seat' ");
        out.println("value='Executive Chair Car'>");
        out.println("EC");
        out.println("<br><br>");
        out.println("<input type='radio' name='seat' ");
        out.println("value='Second Sitting'>");
        out.println("2S");
        out.println("<br><br>");
        out.println("<input type='radio' name='seat' ");
        out.println("value='General / Unreserved Second Class'>");
        out.println("GS / GN");
        out.println("<br><br>");
        out.println("<input type='submit' value='Confirm Booking'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
    private void showConfirmation(HttpServletResponse response,
                                  HttpSession session)
            throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String userId = (String) session.getAttribute("userId");
        String train = (String) session.getAttribute("train");
        String seat = (String) session.getAttribute("seat");
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Booking Confirmation</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Railway Reservation System</h1>");
        out.println("<h2>Booking Confirmation</h2>");
        out.println("<p>User ID: " + userId + "</p>");
        out.println("<p>Train: " + train + "</p>");
        out.println("<p>Coach: " + seat + "</p>");
        out.println("<h2>Booking Confirmed Successfully!</h2>");
        out.println("<p>Session is Active</p>");
        out.println("<br>");
        out.println("<form action='hello' method='post'>");
        out.println("<input type='hidden' name='action' value='logout'>");
        out.println("<input type='submit' value='Logout'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
    private void showLoginMessage(HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Please Login First</h2>");
        out.println("<a href='hello'>Go to Login</a>");
    }
}