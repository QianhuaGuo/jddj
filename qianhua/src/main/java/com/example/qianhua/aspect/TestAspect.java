//package com.example.qianhua.aspect;
//
//import com.alibaba.fastjson.JSONObject;
//import com.example.qianhua.Result;
//import com.example.qianhua.entity.User;
//import com.example.qianhua.exception.BizException;
//import com.example.qianhua.requestVo.TestVo;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Aspect
//@Configuration
//@Slf4j
//public class TestAspect {
//
//    @Around("execution(* com.example.qianhua.controller.TestController.*(..))")
//    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        if (request.getServletPath().equals("/test/testAspectReturn")){
//            return Result.success();
//        }
//        //获取请求头中的数据
//        String catalog = request.getHeader("catalog");
//        System.out.println("catalog:"+catalog);
//        String servletPath = request.getServletPath();
//        System.out.println("servletPath:"+servletPath);
//        Object target = joinPoint.getTarget();
//        Object[] args = joinPoint.getArgs();
//        log.info("请求参数：{}", JSONObject.toJSONString(args));
//        Class<?> aClass = target.getClass();
//        String simpleName = aClass.getSimpleName();
//        System.out.println("simpleName:"+simpleName);
//        System.out.println(joinPoint.getSignature().getName());
//        Object result = null;
//        if (args[0] instanceof TestVo){
//            try {
//                System.out.println("====================开始执行controller的目标方法=====================");
//                result = joinPoint.proceed();
//                delResult(result);
//                System.out.println("====================结束执行======================");
//            } catch (Exception ex) {
//                if (ex instanceof BizException){
//                    log.warn("请求业务异常...");
//                }else{
//                    log.warn("请求异常...");
//                }
//                return Result.fail(ex.getMessage());
//            }
//        }
//        return result;
//    }
//
//    private void delResult(Object result) {
//        if (result instanceof Result){
//            Result r = (Result) result;
//            User user = new User("jj",1,"nan");
//            r.setData(user);
//            r.setMsg("通过aspect设置msg");
//        }
//    }
//}
