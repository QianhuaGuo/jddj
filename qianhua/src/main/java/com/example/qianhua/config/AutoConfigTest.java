package com.example.qianhua.config;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class AutoConfigTest implements BeanNameAware, InitializingBean {
    private String beanName;

    @Override
    public void setBeanName(String name) {
        Properties properties = new Properties();
        try {
            // 使用类加载器加载配置文件
            InputStream inputStream = AutoConfigTest.class.getClassLoader().getResourceAsStream("config.properties");
            properties.load(inputStream);

            // 将properties设置为系统属性
            System.setProperties(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.getProperties();
        this.beanName = name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        beanName = "change";
    }
}
