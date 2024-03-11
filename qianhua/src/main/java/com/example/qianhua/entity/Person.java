package com.example.qianhua.entity;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {

    public void print(){
        System.out.println("我是人类");
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        User l1U1 = new User("张三",15,"men");
        User l1U2 = new User("李四",16,"men");
        User l1U3 = new User("小芳",12,"women");
        users.add(l1U1);
        users.add(l1U2);
        users.add(l1U3);
        users.removeIf(user -> user.getName().equals("李四"));
        System.out.println(JSONObject.toJSONString(users));
//        users.forEach(user -> {
//            if (user.getName().equals("李四")){
//                return;
//            }
//            System.out.println(user.getName());
//        });
//        Person p1 = new Men();
//        Person p2 = new Wonmen();
//
//        check(p1);
//        check(p2);
//        String s = "json .. aws$\\";
//        String s1 = replaceBlank(s);
//        System.out.println(s1);
//        String ss = "中国";
//        byte[] bytes = ss.getBytes();
//        System.out.println(bytes.length);
//        System.out.println(bytes);
    }

    public static void check(Person person){
       person.print();
    }

    public static String replaceBlank(String s){
        String dest = "";
        if (!StringUtils.isEmpty(s)){
            Pattern p = Pattern.compile("\\.|\\$|\\s*|\t|\r|\n|\\\\");
            Matcher matcher = p.matcher(s);
            dest = matcher.replaceAll("");
        }
        return dest;
    }
}
