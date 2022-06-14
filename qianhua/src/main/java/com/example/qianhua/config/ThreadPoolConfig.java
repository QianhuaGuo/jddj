package com.example.qianhua.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.sql.SQLOutput;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ThreadPoolConfig {

    @Bean("threadPoolExecutor")
    public ThreadPoolExecutor getThreadPool(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,
                5,
                60L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(10),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        return threadPoolExecutor;
    }


    @Bean("threadPoolTaskExecutor")
    public ThreadPoolTaskExecutor getThreadPoolTaskExecutor(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(Runtime.getRuntime().availableProcessors() * 3);
        threadPoolTaskExecutor.setMaxPoolSize(Runtime.getRuntime().availableProcessors() * 6);
        threadPoolTaskExecutor.setQueueCapacity(5000);//队列最大容量
        threadPoolTaskExecutor.setKeepAliveSeconds(60);//设置ThreadPoolExecutor的保持活动秒数。默认是60
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());//拒绝策略
        threadPoolTaskExecutor.setThreadFactory(new ThreadFactoryBuilder().setNameFormat("category-manage-taskExecutor-%d").build());
        return threadPoolTaskExecutor;
    }

    public static void main(String[] args) {
        //Java虚拟机可用的处理器数量
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
