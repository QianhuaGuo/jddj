package com.example.qianhua.demo;

import java.util.ArrayList;
import java.util.List;

public class SigtonDemo {

    //防止指令重排导致使用半成品对象
    private static volatile SigtonDemo INSTANT;
//    private static SigtonDemo INSTANT;

    private SigtonDemo(){}

    public static SigtonDemo getINSTANT(){
        if (INSTANT == null){
            synchronized (SigtonDemo.class){
                if (INSTANT == null){
                    INSTANT =  new SigtonDemo();
                }
            }
        }
        return INSTANT;
    }

    public static void main(String[] args) throws Exception {

        List<Integer> l = new ArrayList<>(2);
        l.add(1);
        l.add(1);
        l.add(1);
        for (int i = 0; i < 10; i++) {
//            System.out.println(SigtonDemo.getINSTANT().hashCode());

            new Thread(()->{
                System.out.println(SigtonDemo.getINSTANT().hashCode());
            }).start();
        }

        //可以通过反射来在程序运行时生产新的对象！！！
        Class<?> sigtonDemo = Class.forName("com.example.qianhua.demo.SigtonDemo");
        SigtonDemo o = (SigtonDemo)sigtonDemo.newInstance();
        System.out.println(o.hashCode());
    }
}
