package com.nhnacademy.study.jsp;


import java.util.Random;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebApplicationListener  implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        StudentRepository studentRepository = new MapStudentRepository();

        for(int i=1; i<=10; i++){
            // ... student 1 ~ 10 생성하기
            // 나이 : random 처리 : 20~30
            Random random = new Random();
            String id = "student" + i;
            String name = "아카데미" + i;
            Student student = new Student(id, name, i % 2 == 0 ? Gender.F : Gender.M, random.nextInt(10) + 20);
            studentRepository.save(student);
        }
        // ... application scope에서 studentRepository 객체에 접근할 수 있도록 구현하기
        context.setAttribute("studentRepository", studentRepository); //ServletContext에 저장
    }
}