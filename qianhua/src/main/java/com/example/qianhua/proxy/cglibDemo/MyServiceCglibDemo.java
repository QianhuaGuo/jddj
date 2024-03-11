package com.example.qianhua.proxy.cglibDemo;


import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

public class MyServiceCglibDemo {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(MyService.class);
        enhancer.setCallback(new MyAspect());

        MyService myService = (MyService) enhancer.create();
        myService.doSomething();
    }
}
