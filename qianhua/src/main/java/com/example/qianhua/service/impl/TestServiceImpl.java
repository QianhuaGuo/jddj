package com.example.qianhua.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.qianhua.entity.User;
import com.example.qianhua.service.TestService;
import com.sun.org.apache.bcel.internal.generic.NEWARRAY;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Function;

@Slf4j
@Service
public class TestServiceImpl implements TestService {
    @Resource
    private ThreadPoolTaskExecutor myThreadPool;

    @Resource
    private ThreadPoolExecutor threadPoolExecutor;

    @Override
    public List<User> handlerUser(User user, Function<User,List<User>> fff) {
        System.out.println(JSONObject.toJSONString(user));
        if (user != null){
            List<User> apply = fff.apply(user);
            return apply;
        }
        return new ArrayList<>(0);
    }

    @Async("threadPoolExecutor")
    @Override
    public void testAsync() throws InterruptedException {
        System.out.println("service:"+Thread.currentThread().getName()+"--"+Thread.currentThread().getId());
        Thread.sleep(3000L);
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i=0;i<5;i++){
            threadPoolExecutor.execute(()->{
                try {
                    System.out.println("开始睡5000ms");
                    Thread.sleep(5000L);
                    System.out.println(Thread.currentThread().getName()+"--"+Thread.currentThread().getId());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                    System.out.println("第"+countDownLatch.getCount()+"个线程执行完成！");
                }
            });
        }
        try{
            countDownLatch.await();
        }catch (Exception e){
            System.out.println("出错了");
        }

        System.out.println("所有线程都执行完了");
    }

    @Override
    public void test5Async() {
        Map<String,Object> params = new HashMap<>();
        params.put("key","aa");
        threadPoolExecutor.execute(()->{
            try {
                Thread.sleep(2000L);
                Object key = params.get("key");
                System.out.println(JSONObject.toJSONString(key));
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        });
        System.out.println("main_thread");
    }

    @Override
    public void testLog() {
        ArrayList a = new ArrayList();
        try {
            a.get(2);
        }catch (Exception e){
            log.error(e.getMessage());
            log.error("错误信息：{}",e.getMessage());
            log.error("错误信息：{}",e.getMessage(),e);//ok
            log.info("=============================");
            log.error(e.getMessage(),e);
        }
    }
}
