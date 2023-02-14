package com.example.qianhua;

import com.example.qianhua.config.TestConfig1;
import com.example.qianhua.proxy.EnableAutoDdcAdapterProxy;
import org.openjdk.jol.info.ClassLayout;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;

@EnableAspectJAutoProxy(proxyTargetClass = true)
@SpringBootApplication
@EnableAutoDdcAdapterProxy
@ImportResource(locations = "classpath:spring.xml")
public class QianhuaApplication implements ApplicationRunner {

    public static void main(String[] args) {
        //System.getProperties();
//        Object o = new Object();
//        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        SpringApplication.run(QianhuaApplication.class, args);

//        ClassPathXmlApplicationContext cx = new ClassPathXmlApplicationContext("spring.xml");
//        TestConfig1 testConfig1 = (TestConfig1) cx.getBean("testConfig1");
//        System.out.println(testConfig1.toString());
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("启动加载...");
    }
}
