package com.nhnacademy.study.jsp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentViewGetController implements Command{

    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");
        String studentID = req.getParameter("id");

        Student student = studentRepository.getStudentById(studentID);

        req.setAttribute("student", student);

        return "/view";
    }
}
