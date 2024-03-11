package com.example.qianhua.entity;

public class ThreadLocalDemo {

    static class A implements Runnable{

        @Override
        public void run() {
            System.out.println("线程运行");
        }
    }

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        A a = new A();
        Thread t = new Thread(a);
        System.out.println("当前线程状态1："+t.getState().name());
        t.start();
        System.out.println("当前线程状态2："+t.getState().name());


        String s = threadLocal.get();

        System.out.println("start...");
        new Thread(()->{
            threadLocal.set("A");
            System.out.println(Thread.currentThread().getName()+":"+threadLocal.get());
            threadLocal.remove();
        },"A").start();

        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
            threadLocal.set("B");
            System.out.println(Thread.currentThread().getName()+":"+threadLocal.get());
            threadLocal.remove();
        },"B").start();

        System.out.println("end...");
    }
}
