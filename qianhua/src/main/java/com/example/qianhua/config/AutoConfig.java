package com.example.qianhua.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class AutoConfig {

    public AutoConfig() {
        System.out.println("TestConfiguration容器启动初始化。。。");
    }

    @Bean(name = "myThreadPool")
    public ThreadPoolTaskExecutor getThreadPollTaskExecutor(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(Runtime.getRuntime().availableProcessors() * 3);//核心线程大小
        threadPoolTaskExecutor.setMaxPoolSize(Runtime.getRuntime().availableProcessors() * 6);//最大线程大小
        threadPoolTaskExecutor.setQueueCapacity(5000);//队列最大容量
        threadPoolTaskExecutor.setKeepAliveSeconds(60);//存活时间
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());//拒绝执行时如何处理
        return threadPoolTaskExecutor;
    }
}
