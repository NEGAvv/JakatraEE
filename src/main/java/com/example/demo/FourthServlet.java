package com.example.demo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "fourthServlet", value = "/fourth")
public class FourthServlet extends HttpServlet{
    private String message;

    public void init() {
        message = "Fourth servlet testing: getServletInfo, getLastModified";
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Fourth Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<p>GET method</p>");
        out.println("<ul>");
        out.println("<li>Servlet Info: " + getServletInfo() + "</li>");
        out.println("<li>Last Modified: " + getLastModified(request) + "</li>");
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    public String getServletInfo() {
        return "Fourth Servlet Info: it consists of GET methods and information about the servlet";
    }

    @Override
    public long getLastModified(HttpServletRequest request) {
        return System.currentTimeMillis();
    }
}
