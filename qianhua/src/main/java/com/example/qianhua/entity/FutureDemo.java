package com.example.qianhua.entity;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {
    private static ExecutorService executor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        Future<Integer> calculate = FutureDemo.calculate(5);
//        if (!calculate.isDone()){
//            System.out.println("计算还没结束...");
//            System.out.println("main:"+Thread.currentThread().getName());
//            Thread.sleep(2000L);
//        }
//        Integer integer = calculate.get();
//        System.out.println("integer:"+integer);

        search("标题");
    }

    public static Future<Integer> calculate(Integer num){
        return executor.submit(()->{
            System.out.println("正在计算...");
            System.out.println("线程池："+Thread.currentThread().getName());
            Thread.sleep(5000L);
           return num*num;
        });
    }

    public static void search(String title){
        Future<String> future = executor.submit(() -> {
            Thread.sleep(5000L);
            return "search"+title;
        });
        System.out.println("do other things...");
        try {
            String s = future.get();
            System.out.println(s);
        } catch (ExecutionException | InterruptedException ex) {
            return;
        }
    }
}
