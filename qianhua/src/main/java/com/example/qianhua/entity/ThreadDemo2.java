package com.example.qianhua.entity;

public class ThreadDemo2 implements Runnable{
    @Override
    public void run() {
        System.out.println("任务输出一句话：任务");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadDemo2());
        thread.start();
    }
}
