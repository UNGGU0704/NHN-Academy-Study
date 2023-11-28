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
@WebServlet(name = "studentViewServlet", urlPatterns = "/student-view")
public class StudentViewServlet extends HttpServlet {
    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req == null || resp == null)
            throw new IllegalArgumentException("view null!!!");

        String studentID = req.getParameter("id");

        Student student = studentRepository.getStudentById(studentID);

        req.setAttribute("student",student);

        //todo /student/view.jsp <-- forward
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //todo null check
        if (req == null || resp == null)
            throw new IllegalArgumentException("view null");
        //todo student 저장


        //todo /student/view?id=student1 <-- redirect
        //resp.sendRedirect("/view?id =" + );
    }

}
