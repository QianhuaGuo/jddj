package com.example.qianhua.test;

import com.example.qianhua.entity.User;

import java.util.Arrays;
import java.util.List;

public class StreamDemo {
    public static void main(String[] args) {
        testStream();
    }

    private static void testStream() {
        User u = new User();
        if (!"one".equals(u.getName())){
            System.out.println("ok");
        }

        List<String> l = Arrays.asList("aa","bb","cc","dd","ee");
        l.stream().forEach(ll ->{
            if (ll.equals("bb")){
                return;
            }
        });
        System.out.println("继续");
    }
}
