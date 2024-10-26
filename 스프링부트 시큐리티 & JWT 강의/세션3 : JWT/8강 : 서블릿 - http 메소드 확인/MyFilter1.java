package com.cos.jwt.filter;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter1 implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        //GET, POST, ... 요청을 판별함
        if(req.getMethod().equals("POST")){
            String headerAuth = req.getHeader("Authorization");
            System.out.println(headerAuth);


            if(headerAuth.equals("cos")){
                chain.doFilter(req,res);
            }else{
                PrintWriter out = res.getWriter();
                out.println("인증안됨");
            }
        }



        chain.doFilter(req,res);
    }
}
