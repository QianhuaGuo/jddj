package com.example.qianhua.multiDatasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.util.Assert;

import java.util.Map;

/**
 * 具体实现数据源切换的方法determineCurrentLookupKey()，determineTargetDataSource()
 */
public class MultiDataSourceDymicRouting extends AbstractRoutingDataSource {

    private Map<Object,Object> dataSourceMap;

    private String defaultDataSourceKey;

    @Override
    public void afterPropertiesSet() {
        Assert.notNull(this.dataSourceMap, "dataSourceMap can not be null");
        Assert.notNull(this.dataSourceMap.get(this.defaultDataSourceKey), "dataSourceMap can not be null");
        this.setTargetDataSources(this.dataSourceMap);
        this.setDefaultTargetDataSource(this.dataSourceMap.get(this.defaultDataSourceKey));
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return MultiDataSourceContextHolder.getDataSourceContextkeyholder() == null? this.defaultDataSourceKey:dataSourceMap.get(MultiDataSourceContextHolder.getDataSourceContextkeyholder());
    }

    public Map<Object, Object> getDataSourceMap() {
        return dataSourceMap;
    }

    public void setDataSourceMap(Map<Object, Object> dataSourceMap) {
        this.dataSourceMap = dataSourceMap;
    }

    public String getDefaultDataSourceKey() {
        return defaultDataSourceKey;
    }

    public void setDefaultDataSourceKey(String defaultDataSourceKey) {
        this.defaultDataSourceKey = defaultDataSourceKey;
    }
}
