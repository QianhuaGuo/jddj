package com.example.qianhua.demo;

public class SynchronizedD {

    private static Integer count = 0;

    public static void handler(){
        synchronized (SynchronizedD.class){
            synchronized (SynchronizedD.class){
//                count = count + 1;
                count++;
                System.out.println(Thread.currentThread().getName() + ":" + count);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                handler();
            },"thread-"+i).start();
        }
    }
}
