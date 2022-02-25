package com.example.qianhua.entity;

import com.alibaba.fastjson.JSONObject;
import com.mchange.v1.util.ListUtils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class TestDemo1 {

    public static void main(String[] args) throws ParseException {
            String s = "ra:DATE:2021-12-20 15:50:21,DATE:2022-01-06 10:15:40";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String[] split = s.split(",");
            Date startTime = sdf.parse(split[0].substring(split[0].indexOf("DATE:")+5));
            Date endTime = sdf.parse(split[1].substring(split[1].indexOf("DATE:")+5));

        List<User> users = new ArrayList<>();
        User l1U1 = new User("张三",15,"men");
        User l1U2 = new User("李四",16,"men");
        User l1U3 = new User("小芳",12,"women");
        users.add(l1U1);
        users.add(l1U2);
        users.add(l1U3);
        System.out.println(JSONObject.toJSONString(users));

        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                Integer age1 = o1.getAge();
                Integer age2 = o2.getAge();
                return age1.compareTo(age2);
            }
        });

        System.out.println(JSONObject.toJSONString(users));
    }
}
