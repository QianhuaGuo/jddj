package com.example.qianhua.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 构造函数-》@postConstruct->initializingBean
 */
@Component
public class TestIni implements InitializingBean {
    public TestIni(){
        System.out.println("====执行构造函数====");
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("====调用构造函数之前执行====");
    }

    @PostConstruct
    public void setaaa(){
        System.out.println("====什么时候执行====");
    }
}
