package com.example.qianhua.demo;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo1 {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock(true);
        System.out.println(reentrantLock.isFair());
//        reentrantLock.lock();
//        reentrantLock.unlock();
//        reentrantLock.tryLock();
    }
}
