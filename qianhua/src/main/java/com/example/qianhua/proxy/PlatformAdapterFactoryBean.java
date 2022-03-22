package com.example.qianhua.proxy;

import feign.Feign;
import org.springframework.beans.factory.FactoryBean;

public class PlatformAdapterFactoryBean implements FactoryBean<DdcAdapterClient> {
    private String channelCode;

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }



    @Override
    public DdcAdapterClient getObject() throws Exception {
        DdcAdapterClient ddcAdapterClient = Feign.builder()
                .target(DdcAdapterClient.class,"http://localhost:8080");
        return ddcAdapterClient;
    }

    @Override
    public Class<?> getObjectType() {
        return DdcAdapterClient.class;
    }
}
