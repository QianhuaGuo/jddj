package com.example.qianhua.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadId {
    // Atomic integer containing the next thread ID to be assigned
    private static final AtomicInteger nextId = new AtomicInteger(0);

    // Thread local variable containing each thread's ID
    private static final ThreadLocal<Integer> threadId =
            ThreadLocal.withInitial(() -> nextId.getAndIncrement());

    // Returns the current thread's unique ID, assigning it if necessary
    public static int get() {
        return threadId.get();
    }

    public static void main(String[] args) {
//        ThreadId.get();
        System.out.println("start...");
        new Thread(()->{
//            threadLocal.set("A");
            System.out.println(Thread.currentThread().getName()+":"+threadId.get());
            threadId.remove();
        },"A").start();

        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
//            threadLocal.set("B");
            System.out.println(Thread.currentThread().getName()+":"+threadId.get());
            threadId.remove();
        },"B").start();

        System.out.println("end...");
    }
}
