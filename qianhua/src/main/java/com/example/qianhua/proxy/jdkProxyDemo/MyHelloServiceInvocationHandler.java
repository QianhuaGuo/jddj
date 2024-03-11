package com.example.qianhua.proxy.jdkProxyDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHelloServiceInvocationHandler implements InvocationHandler {

    private Object target;

    public MyHelloServiceInvocationHandler(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理增强处");
        return method.invoke(target,args);
    }
}
