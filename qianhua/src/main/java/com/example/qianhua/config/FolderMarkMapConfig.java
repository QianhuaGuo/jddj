package com.example.qianhua.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "folder")
@NoArgsConstructor
@Getter
@Setter
public class FolderMarkMapConfig {
    Map<String,String> zhMarkMap;
    Map<String,String> enMarkMap;
}
