package com.nhnacademy.study.jsp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentUpdateGetController implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");
        String studentID = req.getParameter("id");

        req.setAttribute("student",studentRepository.getStudentById(studentID));
        //view를 return 합니다.
        return "/update";
    }
}
