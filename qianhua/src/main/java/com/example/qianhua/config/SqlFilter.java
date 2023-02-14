//package com.example.qianhua.config;
//
//
//import com.alibaba.fastjson.JSONObject;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Enumeration;
//import java.util.Map;
//
//@WebFilter(urlPatterns = "/*", filterName = "sqlFilter")
//@Component
//public class SqlFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        CustomHttpServletRequestWrapper request = new CustomHttpServletRequestWrapper((HttpServletRequest) servletRequest);
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        if ("POST".equals(request.getMethod())){
//            String body = new String(request.getBody());
//            JSONObject obj = JSONObject.parseObject(body);
//            for (Map.Entry<String,Object> entry : obj.entrySet()){
//                String value = (String) entry.getValue();
//                if (sqlValidate(value)){
//                    throw new IOException("您发送请求中的参数中含有非法字符");
//                }
//            }
////            obj.forEach((key,value)->{
////                if (sqlValidate((String) value)){
////                    try {
////                        throw new IOException("您发送请求中的参数中含有非法字符");
////                    } catch (IOException e) {
////                        e.printStackTrace();
////                    }
////                }
////            });
//        }
//        if ("GET".equals(request.getMethod())){
//            String sql = "";
//            // 获得所有请求参数名
//            Enumeration<String> names = request.getParameterNames();
//            while (names.hasMoreElements()) {
//                // 得到参数名
//                String name = names.nextElement();
//                // 得到参数对应值
//                String[] values = request.getParameterValues(name);
//                for (int i = 0; i < values.length; i++) {
//                    sql += values[i];
//                }
//            }
//            if (sqlValidate(sql)) {
//                throw new IOException("您发送请求中的参数中含有非法字符");
//            }
//        }
//        filterChain.doFilter(request, response);
//
//    }
//
//    // 效验
//    protected static boolean sqlValidate(String str) {
//        String s = str.toLowerCase();// 统一转为小写
//        String badStr = "select|update|and|or|delete|insert|truncate|char|into|substr|ascii|declare|exec|count|master|into|drop|execute|table|"
//                + "char|declare|sitename|xp_cmdshell|like|from|grant|use|group_concat|column_name|"
//                + "information_schema.columns|table_schema|union|where|order|by|"
//                + "'\\*|\\;|\\-|\\--|\\+|\\,|\\//|\\/|\\%|\\#";// 过滤掉的sql关键字，特殊字符前面需要加\\进行转义
//        // 使用正则表达式进行匹配
//        boolean matches = s.matches(badStr);
//        return matches;
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
//}
