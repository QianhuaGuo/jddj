package com.example.qianhua.entity;

public class ThreadLocalDemo {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        String s = threadLocal.get();

        System.out.println("start...");
        new Thread(()->{
//            threadLocal.set("A");
            System.out.println(Thread.currentThread().getName()+":"+threadLocal.get());
            threadLocal.remove();
        },"A").start();

        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
//            threadLocal.set("B");
            System.out.println(Thread.currentThread().getName()+":"+threadLocal.get());
            threadLocal.remove();
        },"B").start();

        System.out.println("end...");
    }
}
