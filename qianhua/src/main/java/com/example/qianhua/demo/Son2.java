package com.example.qianhua.demo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Son2 extends Dad{
    private String name;

    private int age;

    public static void main(String[] args) {
        String aa = " this is aaa";

        String trim = aa.trim();
        System.out.println(trim);

        System.out.println(aa.replaceAll(" ",""));
    }
}
