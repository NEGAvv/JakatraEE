package com.example.demo;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello Page</title>");
        out.println("<link rel='stylesheet' type='text/css' href='css/style.css'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h1>" + message + "</h1>");
        out.println("<p>Welcome to my styled servlet page! Enjoy your time here.</p>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

    public void destroy() {
    }
}
