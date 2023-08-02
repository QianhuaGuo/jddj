package com.example.qianhua.demo;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ListDemo implements Serializable {

    private static final long serialVersionUID = -794197191018223347L;

    public static void main(String[] args) {

        String msg = "sizemapping:CHK_SIZE_REQUIRED_FIELD_ID_EMPTY:尺码表必填";
        String newMsg = "";
        if (msg.contains("CHK_SIZE_REQUIRED_FIELD_ID_EMPTY")){
            newMsg = msg.replaceAll("最新错误",msg);
        }
        System.out.println(newMsg);

        List<String> aa = new ArrayList<>();
//        aa.add("8486991");
        if (aa.contains("8486991")){
            System.out.println("xxx");
        }
//        List<User> users = new ArrayList<>();
//        User l1U1 = new User("张三",15,"men",true);
//        User l1U2 = new User("李四",16,"men",true);
//        User l1U3 = new User("小芳",12,"women",true);
//        users.add(l1U1);
//        users.add(l1U2);
//        users.add(l1U3);
//
//        String s = "xx";
//        Optional<User> first = users.stream().filter(u -> u.getName().equals(s)).findFirst();
//        User user = null;
//        if (first.isPresent()){
//            user = first.get();
//        }
//        if (false || (!(Objects.isNull(user)) && user.getAge().equals(12))){
//            System.out.println("hhh");
//        }
//        try{
//            ListDemo.printss();
//            System.out.println("sssssss");
//        }catch (Exception e){
//            log.info("exception....");
//            e.printStackTrace();
//        }

    }

    private static void printss() {
        List<String> s = new ArrayList<>();
        s.add("sss");
        s.add("sss");
        s.add("sss");
        try{
            s.get(6);
        }catch (Exception e){
            log.info("indexOutOf....");
//            throw new BizException(e.getMessage());
        }
    }
}
