package com.nhnacademy.study.jsp;

import static javax.servlet.RequestDispatcher.ERROR_EXCEPTION;
import static javax.servlet.RequestDispatcher.ERROR_EXCEPTION_TYPE;
import static javax.servlet.RequestDispatcher.ERROR_MESSAGE;
import static javax.servlet.RequestDispatcher.ERROR_REQUEST_URI;
import static javax.servlet.RequestDispatcher.ERROR_STATUS_CODE;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@WebServlet(name = "errorServlet", urlPatterns = "/error")
public class ErrorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("status_code", req.getAttribute(ERROR_STATUS_CODE));

        //todo exception_type
        Class<?> exceptionType = (Class<?>) req.getAttribute(ERROR_EXCEPTION_TYPE);
        req.setAttribute("exception_type", exceptionType != null ? exceptionType.getName() : "");
        //todo message
        String errorMessage = (String) req.getAttribute(ERROR_MESSAGE);
        req.setAttribute("message", errorMessage != null ? errorMessage : "");
        //todo exception
        Throwable exception = (Throwable) req.getAttribute(ERROR_EXCEPTION);
        req.setAttribute("exception", exception);
        //todo request_uri
        String requestUri = (String) req.getAttribute(ERROR_REQUEST_URI);
        req.setAttribute("request_uri",requestUri != null ? requestUri : "");

        //todo /error.jsp forward 처리
        RequestDispatcher dispatcher = req.getRequestDispatcher("/error.jsp");
        dispatcher.forward(req, resp);

    }

}