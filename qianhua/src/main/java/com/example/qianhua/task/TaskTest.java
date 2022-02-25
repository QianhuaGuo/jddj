package com.example.qianhua.task;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class TaskTest extends QuartzJobBean {
    @Autowired
    private ApplicationContext context;
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        System.out.println("定时任务正在执行...");
    }
}
