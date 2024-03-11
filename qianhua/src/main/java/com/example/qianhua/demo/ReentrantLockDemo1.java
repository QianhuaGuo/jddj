package com.example.qianhua.demo;

import org.aspectj.weaver.ast.Var;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo1 {

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void conditionWait() throws InterruptedException{
        lock.lock();
        try{
            condition.wait();
        }finally {
            lock.unlock();
        }
    }

    public void conditionsignal() throws InterruptedException{
        lock.lock();
        try {
            condition.signal();
        }finally {
            lock.unlock();
        }
    }
}
