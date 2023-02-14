package com.example.qianhua.demo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Son2 extends Dad{
    private String name;

    private int age;
}
