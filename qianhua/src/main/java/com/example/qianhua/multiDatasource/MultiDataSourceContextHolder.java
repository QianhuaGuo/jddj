package com.example.qianhua.multiDatasource;

/**
 * 创建一个线程本地变量（ThreadLocal）来存储当前线程使用的数据源的名称。在开始访问数据库之前，根据需要切换的数据源，设置这个线程本地变量的值。在获取连接的时候，
 * 根据线程本地变量的值，从维护数据源的Map中获取到对应的DataSource，然后通过这个DataSource获取连接。
 *
 * 这样，就实现了在一个线程中根据需要动态切换数据源。
 */
public class MultiDataSourceContextHolder {
    private static final ThreadLocal<String> dataSourceContextkeyholder = new ThreadLocal<>();


    public MultiDataSourceContextHolder() {
    }

    public static void setDataSourceContextkeyholder(String datasourceContextkey){
        dataSourceContextkeyholder.set(datasourceContextkey);
    }

    public static String getDataSourceContextkeyholder() {
        return dataSourceContextkeyholder.get();
    }

    public static void clearDataSourceContextKey(){
        dataSourceContextkeyholder.remove();
    }
}
