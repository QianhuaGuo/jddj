package com.example.qianhua.config;

import cn.hutool.core.util.ObjectUtil;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ObjectUtils;

@Slf4j
@Configuration
public class CustomFeignRequestInterceptor implements RequestInterceptor {
    public static final String SAAS_TENANT_CODE = "saasTenantCode";

    @Override
    public void apply(RequestTemplate template) {
        if (ObjectUtils.isEmpty(template.headers().get(SAAS_TENANT_CODE))){
            template.header(SAAS_TENANT_CODE,"test");
            log.info("feign调用 租户：{}", template.headers().get(SAAS_TENANT_CODE));
        }
    }
}
