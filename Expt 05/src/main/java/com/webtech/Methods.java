package com.webtech;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/methods")
public class Methods extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>GET Method</h2>");
        out.println("Name: " + request.getParameter("name") + "<br>");
        out.println("Email: " + request.getParameter("email") + "<br>");
        out.println("<b>Data visible in URL</b>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>POST Method</h2>");
        out.println("Name: " + request.getParameter("name") + "<br>");
        out.println("Email: " + request.getParameter("email") + "<br>");
        out.println("<b>Data not visible in URL</b>");
    }
}
