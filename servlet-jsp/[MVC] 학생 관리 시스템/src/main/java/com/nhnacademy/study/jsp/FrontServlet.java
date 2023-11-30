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
@WebServlet(name = "frontServlet", urlPatterns = "*.do")
public class FrontServlet extends HttpServlet {
    private static final String REDIRECT_PREFIX="redirect";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //todo 공통 처리 - 응답 content-type, character encoding 지정.
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

    //    try {
            //실제 요청 처리할 servlet을 결정
            //String servletPath = resolveServlet(req.getServletPath());
            String servletPath = req.getServletPath();
            String method = req.getMethod();
            Command command = resolveCommand(servletPath, method);

            //실제 요청을 처리한 servlet이 'view'라는 request 속성값으로 view를 전달해 줌.
            String view = command.execute(req, resp);
            if (view.startsWith(REDIRECT_PREFIX)) {

                log.error("redirect-url : {}", view.substring(REDIRECT_PREFIX.length() + 1));
                // todo  `redirect:`로 시작하면 redirect 처리.
                resp.sendRedirect(view.substring(REDIRECT_PREFIX.length() + 1));

            } else {
                //todo redirect 아니면 JSP에게 view 처리를 위임하여 그 결과를 include시킴.
                log.info("View : " + view + ".jsp");
                RequestDispatcher viewDispatcher = req.getRequestDispatcher(view + ".jsp");
                viewDispatcher.include(req, resp);
            }
        //}
//        }catch(Exception ex){
//            //todo 공통 error 처리 - ErrorServlet 참고해서 처리
//            RequestDispatcher errorDispatcher = req.getRequestDispatcher("/error.jsp");
//            errorDispatcher.forward(req, resp);
//
//            //todo  forward - /error.jsp
//
//        }
    }

    private String resolveServlet(String servletPath){
        String processingServlet = null;
        if("/student/list.do".equals(servletPath)){
            processingServlet = "/student/list";
        }

        //todo 실행할 servlet 결정하기
        switch (servletPath) {
            case "/student.do":
                processingServlet = "/student";
                break;
            case "/student-register.do":
                processingServlet = "/student-register";
                break;
            case "/student-update.do":
                processingServlet = "/student-update";
                break;
            case "/student-view.do":
                processingServlet = "/student-view";
                break;
            case "/student-delete.do":
                processingServlet = "/student-delete";
        }

        return processingServlet;
    }

    private Command resolveCommand(String servletPath, String method) {
        Command command = null;

        // 서블릿 경로에 따라 적절한 Command 객체를 생성
        switch (servletPath) {
            case "/student.do":
                if ("GET".equalsIgnoreCase(method)) {
                    command = new StudentListController();
                }
                break;
            case "/student-register.do":
                if ("GET".equalsIgnoreCase(method)) {
                    command = new StudentRegisterGetController();
                    break;
                } else if ("POST".equalsIgnoreCase(method)) {
                    command = new StudentRegisterPostController();
                    break;
                }

            case "/student-update.do":
                if ("GET".equalsIgnoreCase(method)) {
                    command = new StudentUpdateGetController();
                    break;
                } else if ("POST".equalsIgnoreCase(method)) {
                command = new StudentUpdatePostController();
                break;
                }
            case "/student-view.do":
                command = new StudentViewGetController();
                break;
            case "/student-delete.do":
                if ("POST".equalsIgnoreCase(method)) {
                    command = new StudentDeleteController();
                }
                break;
            // 여기에 다른 서블릿 경로에 따른 Command 추가
        }

        return command;
    }


}