package com.example.qianhua.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class CustomHander extends Handler {

    public CustomHander() {
        System.out.println("构造函数默认加载。。。");
    }

    {
        System.out.println("普通代码块");
    }

    static{
        System.out.println("静态代码块");
    }

    public static void main(String[] args) {
        CustomHander c1 = new CustomHander();
        CustomHander c2 = new CustomHander();

        System.out.println("main方法");
    }
}
