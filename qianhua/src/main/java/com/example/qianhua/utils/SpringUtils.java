package com.example.qianhua.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Component
public class SpringUtils implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static <T> T getBean(String name){
        return (T) applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> clazz){
        return (T) applicationContext.getBean(clazz);
    }

    /**
     * 获取当前环境的配置文件
     * @return
     */
    public static String getActiveProfile(){
        String[] activeProfiles = applicationContext.getEnvironment().getActiveProfiles();
        return (activeProfiles != null && activeProfiles.length != 0)?activeProfiles[0]:null;
    }
}
