package com.example.qianhua.demo;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        createList("aa","bb",data -> {
            System.out.println(data);
        });

//        System.out.println(JSONObject.toJSONString(list));
    }

    public static void createList(String a, String b, Consumer<List<String>> data){
        List<String> c = new ArrayList<>();
        c.add(a);
        c.add(b);
        data.accept(c);
    }
}
