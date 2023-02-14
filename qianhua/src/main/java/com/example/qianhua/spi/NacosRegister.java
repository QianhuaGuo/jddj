package com.example.qianhua.spi;

public class NacosRegister implements Register{
    @Override
    public void register(String host, String port) {
        System.out.println("register service in nacos...");
    }
}
