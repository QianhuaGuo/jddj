package com.example.qianhua.demo;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Java中的死锁主要是由于多线程间竞争资源时，若互相持有对方所需要的锁资源，
 * 这样就会造成一种互相等待的情况，如果没有外力干涉，他们都将无法再向下执行，这就是典型的死锁现象。
 *
 * 产生死锁的四个必要条件：
 *  1.互斥条件：一个资源只能被一个线程使用，如果已经有某个线程使用某个资源，那么其他请求这个资源的线程只能等待
 *  2.请求和保持条件：线程至少持有一个资源，并且在等待其他资源时对已持有的资源不释放
 *  3.不可剥夺条件：线程已获取的资源，在未使用完成之前，不能强行剥夺，只能有持有资源的线程主动释放
 *  4.循环等待条件：若干线程之间形成一种头尾相接等待资源的关系
 */
public class LockDemo {

    private static Object source1 = new Object();
    private static Object source2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue lbq = new LinkedBlockingQueue(2);
        lbq.offer("a");
        lbq.offer("b");

//        lbq.take();
        new Thread(() -> {
            synchronized (source1){
                System.out.println(Thread.currentThread() + " get source1");

                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + " waiting get resource2");
                synchronized (source2){
                    System.out.println(Thread.currentThread() + " get resource2");
                }
            }
        },"线程1").start();

        new Thread(() -> {
            synchronized (source2){
                System.out.println(Thread.currentThread() + " get source2");

                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + " waiting get resource1");
                synchronized (source1){
                    System.out.println(Thread.currentThread() + " get resource1");
                }
            }
        },"线程2").start();
    }
}
