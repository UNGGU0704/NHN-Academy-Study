package com.nhnacademy.study;

import javax.servlet.http.HttpServlet;
import java.io.*;

import java.text.MessageFormat;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
public class requestServlet extends HttpServlet {

    protected static final Logger log = Logger.getLogger(beautifyServlet.class.getName());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");

        try(PrintWriter out = resp.getWriter()){
            out.println("locale=" + req.getLocale());
            out.println("parameter name=" + req.getParameter("userId"));
            out.println("content type=" + req.getContentType());
            out.println("content length=" + req.getContentLengthLong());
            out.println("method=" + req.getMethod());
            out.println("servlet path=" + req.getServletPath());
            out.println("request uri=" + req.getRequestURI());
            out.println("request url=" + req.getRequestURL());
            out.println("User-Agent header=" + req.getHeader("User-Agent"));
        }catch (Exception e){

        }
    }

}
