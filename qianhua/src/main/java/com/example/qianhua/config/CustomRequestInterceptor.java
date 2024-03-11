package com.example.qianhua.config;

import com.example.qianhua.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class CustomRequestInterceptor implements HandlerInterceptor {
    public static final String SAAS_TENANT_CODE = "saasTenantCode";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String saasTenantCode = request.getHeader(SAAS_TENANT_CODE);
        if (StringUtils.isBlank(saasTenantCode)){
            request.setAttribute(SAAS_TENANT_CODE,"test");
            log.info("请求头缺少租户号....");
//            return false;
            throw new BizException("缺少租户号。。。");
        }
        return true;
    }
}
