package com.example.qianhua.demo;

import cn.hutool.system.JvmInfo;
import org.openjdk.jol.info.ClassLayout;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 64bit的java虚拟机下，一个Object对象的大小为16个字节，其中mark work：8个字节，classpointer:4个字节，补齐4个字节
 */
public class JvmDemo {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
//        JvmInfo j = new JvmInfo();
//        System.out.println("info:"+j.getInfo());
//        System.out.println("name:"+j.getName());
//        System.out.println("Vendor:"+j.getVendor());
//        System.out.println("Version:"+j.getVersion());
//
//        JvmDemo jj = new JvmDemo();
//
//        System.out.println("hashCode:"+j.hashCode());
//
//        LinkedList<String> ld = new LinkedList<>();
//        ld.add("2");
//        ld.add("3");
//        ld.add("4");
//        ld.add("5");

//        Queue queue =  new ArrayBlockingQueue()
    }
}
