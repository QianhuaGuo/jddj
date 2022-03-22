package com.example.qianhua;

import com.example.qianhua.proxy.EnableAutoDdcAdapterProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(proxyTargetClass = true)
@SpringBootApplication
@EnableAutoDdcAdapterProxy
public class QianhuaApplication {

    public static void main(String[] args) {
        SpringApplication.run(QianhuaApplication.class, args);
    }

}
