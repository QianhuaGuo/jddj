package com.example.qianhua.demo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        Map<String,String> chm = new ConcurrentHashMap<>();
        chm.put("a","a");
        chm.get("a");

        chm.remove("a");


        HashMap<String,String> map = new HashMap<>();
        map.put("b","b");
        map.remove("b");

        Map<Object, Object> objectObjectMap = Collections.synchronizedMap(new HashMap<>());
    }
}
