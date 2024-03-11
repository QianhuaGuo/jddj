package com.example.qianhua.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.qianhua.demo.UserEvent;
import com.example.qianhua.entity.User;
import com.example.qianhua.service.TestService;
import com.example.qianhua.service.UserService;
import com.example.qianhua.utils.DateUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Function;

@Slf4j
@Service()
@EnableAspectJAutoProxy(exposeProxy = true)
public class TestServiceImpl implements TestService , ApplicationContextAware {
    @Resource
    private ThreadPoolTaskExecutor myThreadPool;

    @Resource
    private ThreadPoolExecutor threadPoolExecutor;

    private ApplicationContext context;

    @Qualifier(value = "userServiceImpl2")
    @Resource
    private UserService userService;

    private final String aa = "kkk";

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
//            Future<List<String>> future = threadPoolExecutor.submit(()->{
//               return  new ArrayList<>();
//            });为什么线程池设计成核心线程+最大线程数，而不是直接设置一个最大的线程数当线程数被使用完时，新来的任务进入工作队列，等有空闲的线程后再来处理呢？
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

//    @Override
//    public void testLog() {
//        ArrayList a = new ArrayList();
//        try {
//            a.get(2);
//        }catch (Exception e){
//            log.error(e.getMessage());
//            log.error("错误信息：{}",e.getMessage());
//            log.error("错误信息：{}",e.getMessage(),e);//ok
//            log.info("=============================");
//            log.error(e.getMessage(),e);
//        }
//    }

    @Override
    public void testLog() {

        Optional<Integer> ageValue = Optional.ofNullable(DateUtils.getValue(User::getAge));

        Optional<String> value = Optional.ofNullable(DateUtils.getValue(User::getName));



//        String re = setBuildVO(null);
//        String re = setBuildVO("1");
        String re = setBuildVO("2");
        List<String> l = Arrays.asList("a","b");
        l.stream().forEach(a ->{
            threadPoolExecutor.execute(() ->{
                try{
                    if (a.equals("a")){
                        l.get(6);
                    }else{
                        log.info("没问题.....");
                    }
                }catch (Exception e){
                    log.info("error:{}",e.getMessage());
//                    throw new BizException(e);
                    throw new RuntimeException("Task exception", e);
                }
            });
        });

    }

    @NotNull(value = "返回值不能为null")
    private String setBuildVO(String key) {
        if (key.equals("1")){
            System.out.println("aaaaa");
            return key;
        }
        return null;
    }

    public void testaa(){
        System.out.println("testaa");
    }

    /**
     * 测试事件
     */
//    @SneakyThrows
//    @Override
//    public void handlerTask() {
//        log.info("主线业务");
//        AtomicReference<String> old = new AtomicReference<>("xx");
////        new Thread(()->{
////            try {
////                Thread.sleep(2000L);
////                old.set(domain(old.get()));
////                log.info(String.valueOf(old));
////            } catch (InterruptedException exception) {
////                exception.printStackTrace();
////            }
////        }).start();
////        domain(old.get());
//        log.info(String.valueOf(old));
//        if (String.valueOf(old).equals("xx")){
//            new Thread(() -> {
//                try{
//                    log.info("开始事件处理");
//                    Thread.sleep(3000L);
//                    context.publishEvent(new UserEvent(this,old));
//                }catch (Exception e){
//                    log.error("xxx");
//                }
//            }).start();
//        }
//        log.info("这是最后的吗？");
//    }


    /**
     * 事件处理不是异步的。。。
     */
    @SneakyThrows
    @Override
    public void handlerTask() {
        log.info("主线业务");
        AtomicReference<String> old = new AtomicReference<>("xx");
//        new Thread(()->{
//            try {
//                Thread.sleep(2000L);
//                old.set(domain(old.get()));
//                log.info(String.valueOf(old));
//            } catch (InterruptedException exception) {
//                exception.printStackTrace();
//            }
//        }).start();
//        domain(old.get());
        log.info(String.valueOf(old));
        context.publishEvent(new UserEvent(this,old));
        log.info("如果最后打印，表示spring事件不是异步执行");
    }

    @Override
    public void resolve(String a, Consumer<String> data, Consumer<Integer> num) {
        data.accept(a);
        num.accept(1);
    }

    @Async("threadPoolExecutor")
    public String domain(String s) throws InterruptedException {
        Thread.sleep(3000L);
        return s + "new";
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
