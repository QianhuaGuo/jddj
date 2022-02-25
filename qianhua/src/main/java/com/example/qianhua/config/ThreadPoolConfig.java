package com.example.qianhua.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ThreadPoolConfig {

    @Bean("threadPoolExecutor")
    public ThreadPoolExecutor getThreadPool(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,
                5,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(10),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        return threadPoolExecutor;
    }
}
