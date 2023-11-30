package com.nhnacademy.study.jsp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentUpdatePostController implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");
        String id = req.getParameter("ID");
        String name = req.getParameter("name");
        Gender gender = Gender.valueOf(req.getParameter("gender"));
        int age = Integer.parseInt(req.getParameter("age"));

        Student student = new Student(id, name, gender, age);
        studentRepository.save(student);

        //  resp.sendRedirect("/student-view?id=" + id);
        //   req.setAttribute("view", "redircet:/student-view?id=" + id);
        req.setAttribute("student", student);
        return "/view";
    }
}
