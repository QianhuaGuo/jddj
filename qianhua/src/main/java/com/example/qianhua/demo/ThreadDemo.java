package com.example.qianhua.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadDemo {
    private static ThreadLocal<String> tl = new ThreadLocal<>();

    private static InheritableThreadLocal<String> iitl = new InheritableThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();


        ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.WriteLock writeLock = rwl.writeLock();
        ReentrantReadWriteLock.ReadLock readLock = rwl.readLock();

        iitl.set("main线程的本地变量");
        tl.set("线程1的本地变量");

        Thread thread = new Thread(() ->{

            try {
//                tl.set("线程1的本地变量");
                String s = iitl.get();
                System.out.println("iitl:"+s);
                System.out.println("tl:"+tl.get());
                System.out.println("ceshi");
                Thread.sleep(1000);
                System.out.println("ceshi");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程1");
        thread.start();


//        thread.join();

        System.out.println("主线程结束");
    }


}
