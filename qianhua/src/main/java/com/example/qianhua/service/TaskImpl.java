package com.example.qianhua.service;

import com.example.qianhua.task.TaskHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskImpl {

    @Value("#{'${extension.apple.tenant.codes:apple}'.split(',')}")
    private List<String> tenantCodes;

    private final List<TaskHandler> handlers;

    public void handler(){
        System.out.println(handlers);
        System.out.println(tenantCodes);
    }
}
