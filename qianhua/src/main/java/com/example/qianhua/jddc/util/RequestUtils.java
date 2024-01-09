package com.example.qianhua.jddc.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Component
public class RequestUtils {
    private static final Logger log = LoggerFactory.getLogger(RequestUtils.class);

    public static String getCookie(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

        return request.getHeader("Cookie");
    }

    public static String getIp(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

//        String remoteAddr = request.getRemoteAddr();


        String ip = request.getHeader("X-Real-IP");
        if (StringUtils.isNotBlank(ip) && "unkonw".equalsIgnoreCase(ip)){
            return ip;
        }else{
            String remoteAddr = request.getRemoteAddr();
            return remoteAddr;
        }
//        return ip;
    }
}
