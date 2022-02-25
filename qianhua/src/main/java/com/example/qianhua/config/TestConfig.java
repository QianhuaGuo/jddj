package com.example.qianhua.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "jddj")
@Component
@Getter
@Setter
public class TestConfig {

    private List<ShopSessionKey> shopSessionKeyList;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class ShopSessionKey {
        private String appKey;
        private String accessToken;
        private String appSecret;
        private String shopCode;
    }

}
