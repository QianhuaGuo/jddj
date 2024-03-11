package com.example.qianhua.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       CustomRequestInterceptor interceptor = new CustomRequestInterceptor();
       registry.addInterceptor(interceptor);
    }
}
