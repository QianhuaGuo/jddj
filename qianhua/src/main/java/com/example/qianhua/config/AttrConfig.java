package com.example.qianhua.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@ConfigurationProperties(prefix = "attr")
@Component
@Setter
@Getter
@NoArgsConstructor
public class AttrConfig {

    private Map<String,String> attrMap;
}
