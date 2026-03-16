package com.webtech;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/process")
public class FormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");

        out.println("<html><body>");

        if (name == null || name.trim().isEmpty()) {
            out.println("<h2>Error: Name cannot be empty</h2>");
        } else {
            try {
                int age = Integer.parseInt(ageStr);

                if (age < 0) {
                    out.println("<h2>Error: Age cannot be negative</h2>");
                } else {
                    out.println("<h2>Hello, " + name + "! You are " + age + " years old.</h2>");
                }

            } catch (NumberFormatException e) {
                out.println("<h2>Error: Age must be a valid number</h2>");
            }
        }

        out.println("<br><a href='index.jsp'>Go Back</a>");
        out.println("</body></html>");
    }
}
