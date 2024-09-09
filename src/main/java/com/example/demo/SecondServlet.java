package com.example.demo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "secondServlet", value = "/second")
public class SecondServlet extends HttpServlet{
    private String message;

    public void init() {
        message = "Second servlet testing: put, delete";
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String age = request.getParameter("age");

        out.println("<html>");
        out.println("<head>");
        out.println("<title>PUT Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        if (name != null && age != null) {
            out.println("<h1>Updated user: " + name + "</h1>");
            out.println("<p>Updated age to " + age + "</p>");
        } else {
            out.println("<h1>PUT method</h1>");
            out.println("<p>Please provide 'name' and 'age' parameters.</p>");
        }
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("id");

        out.println("<html>");
        out.println("<head>");
        out.println("<title>DELETE Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        if (id != null) {
            out.println("<h1>Deleted: " + id + "</h1>");
        } else {
            out.println("<h1>DELETE method</h1>");
            out.println("<p>Please provide 'id' parameter.</p>");
        }
        out.println("</body>");
        out.println("</html>");
    }

}
