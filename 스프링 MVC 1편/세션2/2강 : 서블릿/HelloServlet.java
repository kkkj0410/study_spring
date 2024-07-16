package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    
    @Override
    //req, res 발생 시, service함수가 실행됨
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.service(req, resp);
        
        System.out.println("Hello Servlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        //~~/hello?username="string"으로 url접속 시, username은 "string"에 있는 값을 가지게 됨
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        //사용자에게 전달하는 값의 정보
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello " + username);
    }
}
