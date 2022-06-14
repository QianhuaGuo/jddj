package com.example.qianhua.controller;

public class Handler {
    public Handler() {
        System.out.println("handler.");
    }
    {
        System.out.println("父类普通代码块");
    }
    static{
        System.out.println("父类静态代码块");
    }
}
