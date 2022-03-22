package com.example.qianhua.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DdcAdapterServiceSupport {

    public static String getDdcAdapterClientBeanName(String channelCode) {
        String beanName = "com.baozun.midcenter.publish.proxy.client.internalAutoProxyDdcAdapterClient.%s";
        return String.format(beanName,channelCode.toLowerCase());
    }
}
