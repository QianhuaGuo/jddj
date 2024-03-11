package com.example.qianhua.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 写锁是支持可重入的排它锁
 * 读锁是支持可重入的共享锁
 * 锁降级：当前线程把持住（当前拥有的）写锁，在获取读锁，随后释放（先前拥有的）写锁的过程。
 */
public class ReadWriteLockDemo {
    static Map<String,Object> map = new HashMap<>();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    static Lock r = rwl.readLock();
    static Lock w = rwl.writeLock();

    //获取一个key对应的value(读)
    public static final Object get(String key){
        r.lock();
        try{
            return map.get(key);
        }finally {
            r.unlock();
        }
    }

    //设置key对应的value，并返回旧值(写)
    public static final Object put(String key,Object value){
        w.lock();
        try{
            return map.put(key,value);
        }finally {
            w.unlock();
        }
    }

    //清空所有内容
    public static final void clear(){
        w.lock();
        try{
            map.clear();
        }finally {
            w.unlock();
        }
    }
}
