package com.nhnacademy.study.jsp;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "studentRegisterServlet", urlPatterns = "/student-register")
public class StudentRegisterServlet extends HttpServlet {

    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("register.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req == null || resp == null)
            throw new IllegalArgumentException("doPost NUll!");

        String id = req.getParameter("ID");
        String name = req.getParameter("name");
        Gender gender = Gender.valueOf(req.getParameter("gender"));
        int age = Integer.parseInt(req.getParameter("age"));

        studentRepository.save(new Student(id, name, gender, age));

        String queryString = "id=" + id;
        resp.sendRedirect("/student-view?" + queryString);
    }

}