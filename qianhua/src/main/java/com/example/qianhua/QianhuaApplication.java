package com.example.qianhua;

import com.example.qianhua.config.TestConfig1;
import com.example.qianhua.proxy.EnableAutoDdcAdapterProxy;
import com.example.qianhua.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Map;
import java.util.Properties;

@Slf4j
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableAsync
@SpringBootApplication
@EnableAutoDdcAdapterProxy
@ImportResource(locations = "classpath:spring.xml")
public class QianhuaApplication implements ApplicationRunner {

    public static void main(String[] args) {

        //System.getProperties();
//        Object o = new Object();
//        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        ConfigurableApplicationContext context = SpringApplication.run(QianhuaApplication.class, args);
        Map<String, UserService> beansOfType = context.getBeansOfType(UserService.class);
        ConfigurableEnvironment environment = context.getEnvironment();
        String[] activeProfiles = environment.getActiveProfiles();
        for (String profile : activeProfiles) {
            log.info("------------ Spring Boot 使用profile为:{}------------ ", profile);
        }
        log.info("server.port:{}", environment.getProperty("server.port"));

//        ClassPathXmlApplicationContext cx = new ClassPathXmlApplicationContext("spring.xml");
//        TestConfig1 testConfig1 = (TestConfig1) cx.getBean("testConfig1");
//        System.out.println(testConfig1.toString());

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("启动加载...");
    }
}
