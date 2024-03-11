package com.example.qianhua.demo;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo2<T> {
    private Object[] items;
    //添加的下标、删除的下标、当前数组数量
    private int addIndex,removeIndex,count;
    Lock lock = new ReentrantLock();
    Condition notEmpty = lock.newCondition();//不为空
    Condition notFull = lock.newCondition();//没有满

    public ReentrantLockDemo2(Object[] items) {
        this.items = items;
    }

    //添加一个元素，如果数组满，则添加线程进入等待状态，直到有“空位”
    public void add(T t) throws InterruptedException{
        lock.lock();
        try{
            while (count == items.length){
                //添加线程进入等待状态
                notFull.await();
            }
            items[addIndex] = t;
            if (++addIndex == items.length){
                addIndex = 0;
            }
            ++count;
            //唤醒删除线程
            notEmpty.signal();
        }finally {
            lock.unlock();
        }
    }

    //由头部删除一个元素，如果数组时空，则删除线程进入等待状态，直到数组有新元素添加
    public T remove(T t) throws InterruptedException{
        lock.lock();
        try {
            while (count == 0){
                //删除线程进入等待状态
                notEmpty.await();
            }
            Object X = items[removeIndex];
            if (++removeIndex == items.length){
                removeIndex = 0;
            }
            --count;
            //唤醒添加线程
            notFull.signal();
            return (T) X;
        }finally {
            lock.unlock();
        }
    }
}
