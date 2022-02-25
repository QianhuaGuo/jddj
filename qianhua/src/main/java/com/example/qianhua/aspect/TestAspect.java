package com.example.qianhua.aspect;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Configuration
@Slf4j
public class TestAspect {

    @Around("execution(* com.example.qianhua.controller.TestController.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Exception{
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //获取请求头中的数据
        String catalog = request.getHeader("catalog");
        System.out.println("catalog:"+catalog);
        String servletPath = request.getServletPath();
        System.out.println("servletPath:"+servletPath);
        Object target = joinPoint.getTarget();
        Object[] args = joinPoint.getArgs();
        log.info("请求参数：{}", JSONObject.toJSONString(args));
        Class<?> aClass = target.getClass();
        String simpleName = aClass.getSimpleName();
        System.out.println("simpleName:"+simpleName);
        System.out.println(joinPoint.getSignature().getName());
        Object result = null;
        if (args[0] instanceof String){

            try {
                System.out.println("====================开始执行controller的目标方法=====================");
                result = joinPoint.proceed();
                System.out.println("====================结束执行======================");
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        return result;
    }
}
