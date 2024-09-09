package com.example.demo;
import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "firstServlet", value = "/first")
public class FirstServlet extends HttpServlet{
    private String message;

    public void init() {
        message = "First servlet testing: get, post";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>First Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<p>GET method</p>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String age = request.getParameter("age");

        out.println("<html>");
        out.println("<head>");
        out.println("<title>POST Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        if (name != null && age != null) {
            out.println("<h1>Welcome, " + name + "!</h1>");
            out.println("<p>Your age is " + age + "</p>");
        } else {
            out.println("<h1>POST method</h1>");
            out.println("<p>Please write down 'name' and 'age' .</p>");
        }
        out.println("</body>");
        out.println("</html>");
    }

}
