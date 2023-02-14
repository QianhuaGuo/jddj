package com.example.qianhua.demo;

import cn.hutool.system.JvmInfo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class JvmDemo {
    public static void main(String[] args) {
        JvmInfo j = new JvmInfo();
        System.out.println("info:"+j.getInfo());
        System.out.println("name:"+j.getName());
        System.out.println("Vendor:"+j.getVendor());
        System.out.println("Version:"+j.getVersion());

        JvmDemo jj = new JvmDemo();

        System.out.println("hashCode:"+j.hashCode());

        LinkedList<String> ld = new LinkedList<>();
        ld.add("2");
        ld.add("3");
        ld.add("4");
        ld.add("5");

//        Queue queue =  new ArrayBlockingQueue()
    }
}
