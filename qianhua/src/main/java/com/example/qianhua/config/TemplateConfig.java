package com.example.qianhua.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@EnableConfigurationProperties
@ConfigurationProperties(prefix = "template")
@Component
@Getter
@Setter
@NoArgsConstructor
public class TemplateConfig {

    private String detailId;

    private String sourceId;

    private String videoId;
}
