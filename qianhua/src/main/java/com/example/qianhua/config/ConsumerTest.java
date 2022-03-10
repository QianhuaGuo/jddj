package com.example.qianhua.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("consumerTest")
public class ConsumerTest {

    private static Logger logger = LoggerFactory.getLogger(ConsumerTest.class);

    public ConsumerTest(){
        System.out.println("consumerTest...");
        this.handMessage();
    }

    public void handMessage(){
        System.out.println("正在消费...");
    }
}
