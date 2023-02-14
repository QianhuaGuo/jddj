package com.example.qianhua.filter;

import java.util.concurrent.CopyOnWriteArrayList;

public class FilterManager {
    private volatile static FilterManager filterManager;
    private void FilterChain(){}

    private CopyOnWriteArrayList list = new CopyOnWriteArrayList();

    public void add(FilterChain filter){
        list.add(filter);
    }

    public static FilterManager getSington(){
        if (filterManager == null){
            synchronized (FilterManager.class){
                if (filterManager == null){
                    filterManager = new FilterManager();
                }
            }
        }
        return filterManager;
    }
}
