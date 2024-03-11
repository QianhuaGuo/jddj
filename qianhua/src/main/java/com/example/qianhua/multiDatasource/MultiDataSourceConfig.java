package com.example.qianhua.multiDatasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MultiDataSourceConfig {

    public static final String MAIN_DATA_SOURCE = "mainDataSource";
    public static final String REPORTDORIS_DATA_SOURCE = "reportDataSource";

    @Bean(name = MAIN_DATA_SOURCE)
    @ConfigurationProperties("spring.datasource.maindatasource")
    public DataSource mainDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = REPORTDORIS_DATA_SOURCE)
    @ConfigurationProperties("spring.datasource.reportdorisdatasource")
    public DataSource reportDirosDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public MultiDataSourceDymicRouting datasource(){
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put(MAIN_DATA_SOURCE, mainDataSource());
        if (reportDirosDataSource() != null) {
            dataSourceMap.put(REPORTDORIS_DATA_SOURCE, reportDirosDataSource());
        }
        MultiDataSourceDymicRouting multiDataSourceRouting = new MultiDataSourceDymicRouting();
        multiDataSourceRouting.setDataSourceMap(dataSourceMap);
        multiDataSourceRouting.setDefaultDataSourceKey(MAIN_DATA_SOURCE);
        return multiDataSourceRouting;
    }
}
