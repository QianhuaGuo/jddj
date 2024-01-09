package com.example.qianhua.demo;

import com.example.qianhua.entity.Task;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TaskDemo {

    public static void main(String[] args) throws JsonProcessingException {
        Task task = new Task();
        task.setTotal(100);

        ObjectMapper objectMapper = new ObjectMapper();

        String jsonTask = objectMapper.writeValueAsString(task);

        System.out.println(jsonTask);




    }
}
