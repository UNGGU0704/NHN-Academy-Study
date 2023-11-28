package com.nhnacademy.study.jsp;

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
@WebServlet(name = "studentUpdateServlet", urlPatterns = "/student-update")
public class StudentUpdateServlet extends HttpServlet {
    private StudentRepository studentRepository;
    @Override
    public void init(ServletConfig config) throws ServletException {
        studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //todo 학생조회
        String studentID = req.getParameter("id");

        req.setAttribute("student",studentRepository.getStudentById(studentID));

        //todo forward : /student/register.jsp
        RequestDispatcher dispatcher = req.getRequestDispatcher("update.jsp");
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

        resp.sendRedirect("/student-view?id=" + id);
    }
}
