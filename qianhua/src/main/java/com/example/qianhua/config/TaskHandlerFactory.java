package com.example.qianhua.config;

import com.example.qianhua.entity.Task;
import com.example.qianhua.task.TaskHandler;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class TaskHandlerFactory implements ApplicationContextAware {

    private Map<String, TaskHandler> taskHandlerMap = new ConcurrentHashMap<>();
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        for (TaskHandler handler : applicationContext.getBeansOfType(TaskHandler.class).values()) {
            taskHandlerMap.put(handler.getClass().getSimpleName(),handler);
        }
    }
}
