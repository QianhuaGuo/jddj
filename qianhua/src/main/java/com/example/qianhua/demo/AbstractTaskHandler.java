package com.example.qianhua.demo;

import com.example.qianhua.service.TestService;

public abstract class AbstractTaskHandler<T> {

    public TestService testService;


    public AbstractTaskHandler(TestService testService) {
        this.testService = testService;
    }


    protected abstract void handleOrderTask(T task);
}
