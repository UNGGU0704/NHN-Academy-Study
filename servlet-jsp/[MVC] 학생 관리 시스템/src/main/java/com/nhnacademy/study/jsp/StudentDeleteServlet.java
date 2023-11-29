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
@Slf4j
@WebServlet(name = "studentDeleteServlet", urlPatterns = "/student-delete")
public class StudentDeleteServlet extends HttpServlet {

    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //todo get parameter  : id , id가 존재하지 않을경우 throw new RuntimeException("...")

        String studentID = req.getParameter("id");
        if (!studentRepository.existById(studentID))
            throw new RuntimeException("해당 id가 없습니다.");

        studentRepository.deleteById(studentID);
       req.setAttribute("view", "redirect:/student.do");
    }
}