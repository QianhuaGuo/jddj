package com.example.qianhua.config;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Set;

@Slf4j
@Configuration
public class CustomOkhttp3RequestInterceptor implements Interceptor {
    public static final String SAAS_TENANT_CODE = "saasTenantCode";
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();

        Set<String> names = originalRequest.headers().names();

        if (!names.contains(SAAS_TENANT_CODE)){
            Request newRequest = originalRequest.newBuilder().addHeader("SAAS_TENANT_CODE", "test").build();

            return chain.proceed(newRequest);
        }else{
            chain.proceed(originalRequest);
        }
        throw new IllegalStateException("Unexpected code path");
    }
}
