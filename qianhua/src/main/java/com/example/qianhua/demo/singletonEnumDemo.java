package com.example.qianhua.demo;

public class singletonEnumDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(signtonEnum.INSTANT.getSingleton().hashCode());
        }
    }
}
