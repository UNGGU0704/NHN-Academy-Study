package com.nhnacademy.study;

import java.util.Objects;
import javax.servlet.http.HttpServlet;
import java.util.Optional;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class responseServlet extends HttpServlet {

    protected static final Logger log = Logger.getLogger(responseServlet.class.getName());
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    /* TODO#1 buffer Size 설정
        1024 byte = 1kb
         - 1KB 이하의 작은 양의 데이터 전송 시 출력 buffer가 꽉 차지 않아도 바로 전송.
         - 1KB 이상의 큰 데이터양을 전송할 때는 출력 버퍼가 가득 차기 전까지 데이터를 쌓은 다음에 한 번에 전송.
         - default bufferSize : 8192 byte = 8K
     */
        int bufferSize = 1024;
        if (bufferSize < 1024) {
            resp.setBufferSize(bufferSize);
        } else {
            resp.setBufferSize(8192);
        }

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");

        try(PrintWriter out = resp.getWriter()){

            out.println("locale=" + req.getLocale());
            out.println("parameter name=" + req.getParameter("name"));
            // TODO#2 flush 버퍼링 된 출력 바이트를 즉시 쓰도록(소켓을 통해서 내보냄) 강제함. clinet와 연결이 종료됨. 즉.. 아래 로직은 실행되더라도.. 브라우저에 표시 안됨..
//            out.flush();  // 현재까지 퍼퍼링된 출력을 강제로 전송
//            out.close();  // 출럭겨이 불가능하게 닫아버린다.

            String userId = req.getParameter("userId");
       //     log.info("userId:{}",userId);
            if (userId == null || userId.isEmpty()) {
                // TODO#3 response를 초기화.
                resp.reset();

                // TODO#4 error 코드를 500 설정함
                resp.setStatus(500);
                // TODO #5  error 코드를 500으로 설정하고 error message  'name is empty' 설정함.
                resp.sendError(500, "name is empty");
                return;
            }

            //TODO#6 redirect
            String redirect = req.getParameter("redirect");
            log.info("redirect!" + redirect);
            if(Objects.nonNull(redirect)){
                resp.sendRedirect(redirect);
                return;
            }

            out.println("method=" + req.getMethod());
            out.println("request uri=" + req.getRequestURI());

            //TODO#7 reset buffer - response 객체에 담겨있던 모든 buffer 초기화
            /*resp.resetBuffer();*//**/

            out.println("User-Agent header=" + req.getHeader("User-Agent"));

        }catch (Exception e){
       //     log.log("/req : {}",e.getMessage(),e);
        }


    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
