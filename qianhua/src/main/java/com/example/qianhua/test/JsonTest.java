package com.example.qianhua.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.qianhua.entity.User;

import java.math.BigDecimal;
import java.util.*;

public class JsonTest {
    public static void main(String[] args) {

        Map<String,Object> mm = new HashMap<>();
//        List<String> ls = Arrays.asList("aa","bb","cc");
        List<String> ls = new ArrayList<>();
        mm.put("ls",ls);
        List<String> gls = (List<String>) mm.get("ls");

        System.out.println("============================");



        String product = "{\"后跟高\":\"低跟(1-3cm)\",\"帮面材质\":\"驴皮（革）\",\"跟底款式\":\"镂空跟\",\"适用对象\":\"儿童（18周岁以下）\",\"鞋头款式\":\"包头\",\"风格\":\"轻熟\"}";
        String substring = product.substring(2, product.length() - 2);
        String[] split = substring.split(",");
        StringBuffer sb = new StringBuffer();
        for (int i = 0 ;i<split.length;i++){
            String s = split[i];
            String[] split1 = s.split(":");
            sb.append(split1[0]).append("|").append(split1[1]).append("^");
        }
        String s = sb.toString().substring(0,substring.length()).replaceAll("\"", "");

        List<User> users = new ArrayList<>();
        User l1U1 = new User("张三",15,"men");
        User l1U2 = new User("李四",16,"men");
        User l1U3 = new User("小芳",12,"women");
        users.add(l1U1);
        users.add(l1U2);
        users.add(l1U3);

        String array = JSON.toJSONString(users);
        System.out.println(array);

        String price = "33.00";
//        BigDecimal decimal = new BigDecimal(price);
//        BigDecimal res = decimal.multiply(new BigDecimal(100));
        BigDecimal bigDecimal = new BigDecimal(price);
        System.out.println(price);


//        System.out.println(new BigDecimal("33.00"));

    }
}
