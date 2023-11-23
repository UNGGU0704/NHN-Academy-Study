package com.nhnacademy.study;

import java.io.*;

import java.util.Objects;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
    private static Logger log = Logger.getLogger(HelloServlet.class.getName());
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = getServletConfig().getInitParameter("title");
        String name = getServletConfig().getInitParameter("name");

        if (Objects.isNull(title)) {
            title = "who..?";
        }
        if (Objects.isNull(name)) {
            name = "is you?";
        }
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
            writer.printf("<h1> Hello %s %s </h1>\n" , title, name);
            writer.println("</body>");
            writer.println("</html>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init 실행");
        log.info("init 실행 !");
        super.init(config);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("service 실행!");
        super.service(req, resp);
    }

    @Override
    public void destroy() {
        log.info("destroy 실행");
        super.destroy();
    }
}