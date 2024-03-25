package com.example.qianhua.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {
    @Autowired
    private Teacher teacher;

    public Student(){
        System.out.println("Student init:"+teacher);
    }
}
