package com.example.qianhua.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Teacher {

    @Autowired
    private Student student;

    public Teacher(){
        System.out.println("teacher init:"+student);
    }
}
