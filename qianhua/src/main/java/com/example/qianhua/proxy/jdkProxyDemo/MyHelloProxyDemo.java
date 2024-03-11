package com.example.qianhua.proxy.jdkProxyDemo;

import java.lang.reflect.Proxy;

/**
 * JDK 动态代理
 * 1.代理的是接口
 * 2.代理对象都是继承Proxy类（所以为什么只能代理接口的原因）
 * 3.具体处理需要定义一个实现InvocationHandler类，类中确认目标对象。
 *
 * 具体生产代理对象在Proxy.newProxyInstance-》getProxyClass0(loader, intfs)-》cons.newInstance(new Object[]{h});
 */
public class MyHelloProxyDemo {
    public static void main(String[] args) {
        MyHelloServiceInvocationHandler invocationHandler = new MyHelloServiceInvocationHandler(new HelloServiceImpl());
        HelloService helloService = (HelloService) Proxy.newProxyInstance(
                HelloService.class.getClassLoader(),
                new Class[]{HelloService.class},
                invocationHandler);
        System.out.println(helloService instanceof Proxy);
        System.out.println(helloService.getClass().getSuperclass());

        helloService.sayHello();
    }
}
