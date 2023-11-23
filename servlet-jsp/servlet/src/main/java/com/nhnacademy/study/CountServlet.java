package com.nhnacademy.study;

import java.util.Optional;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountServlet extends HttpServlet {
    private  static final Logger log = Logger.getLogger(CountServlet.class.getName());

    private long counter;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        counter = Optional.ofNullable(config.getInitParameter("counter"))
                .map(Long::parseLong)
                .orElse(0l);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        counter++;

        try(PrintWriter writer = resp.getWriter()){
            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<meta charset='utf-8'>");
            writer.println("</head>");
            writer.println("<body>");
            writer.printf("<h1>%d</h1>\n",counter);
            writer.println("</body>");
            writer.println("</html>");
        }catch (IOException ex){
            log.info(ex.getMessage());
        }
    }
}
