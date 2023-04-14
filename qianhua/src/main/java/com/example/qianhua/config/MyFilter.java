//package com.example.qianhua.config;
//
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.annotation.*;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//
//@Component
//public class MyFilter implements Filter {
//    @Override
//    public void init(FilterConfig config) throws ServletException {
//        Filter.super.init(config);
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//        HttpServletRequest req = (HttpServletRequest) request;
//        String spath = req.getServletPath();
//        String[] urls = {"/login","/json",".js",".css",".ico",".jpg",".png"};
//        boolean flag = true;
//        for (String str : urls) {
//            if (spath.indexOf(str) != -1) {
//                flag =false;
//                break;
//            }
//        }
//
//        chain.doFilter(request, response);
//    }
//}
