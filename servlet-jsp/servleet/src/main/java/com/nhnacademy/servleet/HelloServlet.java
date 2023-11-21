package com.nhnacademy.servleet;

import java.io.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        try(PrintWriter writer = response.getWriter()) {
            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<meta charset='utf-8'>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<h1>hello servlet!</h1>");
            writer.println("<h1>안녕 서블릿!</h1>");
            writer.println("</body>");
            writer.println("</html>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}