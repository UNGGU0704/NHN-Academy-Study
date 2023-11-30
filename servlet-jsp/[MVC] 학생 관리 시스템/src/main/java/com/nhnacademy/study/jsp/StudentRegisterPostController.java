package com.nhnacademy.study.jsp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentRegisterPostController implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");
        String id = req.getParameter("ID");
        String name = req.getParameter("name");
        Gender gender = Gender.valueOf(req.getParameter("gender"));
        int age = Integer.parseInt(req.getParameter("age"));

        Student student = new Student(id, name, gender, age);
        studentRepository.save(student);

//        req.setAttribute("id", id);
//        RequestDispatcher viewDispatcher = req.getRequestDispatcher("student-view");
//        viewDispatcher.include(req, resp);

        req.setAttribute("student", student);
        return "view";
    }

}
