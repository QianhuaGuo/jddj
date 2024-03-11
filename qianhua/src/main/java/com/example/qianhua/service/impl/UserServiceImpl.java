package com.example.qianhua.service.impl;

import com.example.qianhua.demo.UserEvent;
import com.example.qianhua.service.UserService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Primary;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * 两种方式都可行
 */
@Primary
@Service()
@Slf4j
public class UserServiceImpl implements /**UserService*/ ApplicationListener<UserEvent> {
    @SneakyThrows
    @Override
    public void onApplicationEvent(UserEvent event) {
        log.info("进入事件处理...");
        Thread.sleep(2000);
        System.out.println(event.getSource());
        log.info("event.old:{}",event.getOld());
    }

//    @EventListener
//    public void testEvent(UserEvent event){
//        log.info("进入事件处理...");
//        try{
//            Thread.sleep(3000L);
//            System.out.println(event.getSource());
//            log.info("event.old:{}",event.getOld());
//        }catch (Exception e){
//            log.error("xxxx");
//        }
//
//    }
}
