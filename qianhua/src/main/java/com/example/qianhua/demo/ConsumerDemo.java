package com.example.qianhua.demo;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

//        createList("aa","bb",data -> {
//            System.out.println(data);
//        });

        createList("aa","bb",data->data.forEach(a ->{
            System.out.println(a);
            handlerString(a);
        }));
    }

    private static void handlerString(String a) {
        System.out.println("处理："+a);
    }

    public static void createList(String a, String b, Consumer<List<String>> aa){
        List<String> c = new ArrayList<>();
        c.add(a);
        c.add(b);
        aa.accept(c);
    }
}
