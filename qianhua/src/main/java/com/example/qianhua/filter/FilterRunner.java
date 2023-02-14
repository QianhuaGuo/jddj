package com.example.qianhua.filter;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.TreeMap;

@Component
@Slf4j
public class FilterRunner implements CommandLineRunner {

    @Resource
    private ExtensionLoader extensionLoader;

    @Override
    public void run(String... args) throws Exception {
        log.info("filter running start...");
        TreeMap<String, Object> extensionLoader = this.extensionLoader.getExtensionLoader(FilterChain.class);
        extensionLoader.values().stream().forEach(e -> {FilterManager.getSington().add((FilterChain) e);});
    }
}
