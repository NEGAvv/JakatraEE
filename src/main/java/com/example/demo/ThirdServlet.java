package com.example.demo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "thirdServlet", value = "/third")
public class ThirdServlet extends HttpServlet{
    private String message;

    public void init() {
        message = "Third servlet testing: head, options";
    }

    @Override
    protected void doHead(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        response.setHeader("X-Custom-Header", "This is a custom header for HEAD request");

        System.out.println("doHead method called for " + request.getRequestURI());
    }

    @Override
    protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setHeader("Allow", "OPTIONS, HEAD");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Third Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<p>OPTIONS method</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
