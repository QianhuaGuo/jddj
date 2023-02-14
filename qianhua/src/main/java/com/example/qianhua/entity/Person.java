package com.example.qianhua.entity;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {

    public void print(){
        System.out.println("我是人类");
    }

    public static void main(String[] args) {
//        Person p1 = new Men();
//        Person p2 = new Wonmen();
//
//        check(p1);
//        check(p2);
//        String s = "json .. aws$\\";
//        String s1 = replaceBlank(s);
//        System.out.println(s1);
        String ss = "中国";
        byte[] bytes = ss.getBytes();
        System.out.println(bytes.length);
        System.out.println(bytes);
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
