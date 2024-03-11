package com.example.qianhua.proxy.cglibDemo;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyAspect implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("before advice");
        Object result = methodProxy.invokeSuper(o, args);
        System.out.println("after advice");
        return result;
    }
}
