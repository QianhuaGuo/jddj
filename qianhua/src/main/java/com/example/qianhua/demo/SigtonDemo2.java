package com.example.qianhua.demo;

public class SigtonDemo2 {
    public static void main(String[] args) throws Exception{
        Class<?> aClass = Class.forName("com.example.qianhua.demo.signtonEnum");
        signtonEnum o = (signtonEnum)aClass.newInstance();
        System.out.println(o.hashCode());
        for (int i = 0;i<10;i++){
            new Thread(() -> System.out.println(signtonEnum.INSTANT.hashCode())).start();
        }
    }
}
