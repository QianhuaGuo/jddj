package com.example.qianhua.entity;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;

import javax.jws.soap.SOAPBinding;
import java.util.*;


public class TableDemo {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        List<User> users = new ArrayList<>();
        User l1U1 = new User("张三",15,"男");
        User l1U2 = new User("李四",16,"男");
        User l1U3 = new User("小芳",12,"女");
//        User l1U4 = new User("小芳",15,"女");
        users.add(l1U1);
        users.add(l1U2);
        users.add(l1U3);
//        users.add(l1U4);

        Map<String, User> uMap = Maps.uniqueIndex(users, User::getName);
        uMap.forEach((k,v) -> {
            System.out.println("K:"+k+"===="+"v"+JSONObject.toJSONString(v));
        });

        List<String> aa = Arrays.asList("121","222");

        Map<String,Object> mm = new HashMap<>();
        mm.put("aa",aa);
        mm.put("users",users);
        List<String> a = (List<String>) mm.get("aa");
        List<User> uu = (List<User>) mm.get("users");

        System.out.println(JSONObject.toJSONString(a));
        System.out.println(JSONObject.toJSONString(uu));

        System.out.println("------------------------------------");
        map.put("name","张三");
        map.put("school","北大");

        Collection<String> values = map.values();
        System.out.println("values:"+JSONObject.toJSONString(values));


//        System.out.println(JSONObject.toJSONString(map));

        Table<String,String,User> tt = TreeBasedTable.create();



        map.forEach((k,v) -> {
            if (k.equals("name")){
                User u1 = users.stream().filter(u -> u.getName().equals("张三")).findFirst().orElse(null);
                if (null != u1){
                    tt.put(k,v,u1);
                }
            }
        });
        for (Table.Cell<String, String, User> stringStringUserCell : tt.cellSet()) {
            String rowKey = stringStringUserCell.getRowKey();
            String columnKey = stringStringUserCell.getColumnKey();
            System.out.println("rowKey"+ rowKey);
            System.out.println("columnKey"+ columnKey);
        }
    }
}
