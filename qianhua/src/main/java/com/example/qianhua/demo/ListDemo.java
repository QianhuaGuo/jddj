package com.example.qianhua.demo;

import com.example.qianhua.entity.User;
import com.example.qianhua.requestVo.TestVo;
import com.example.qianhua.utils.ListSplitUtil;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.fasterxml.jackson.core.JsonEncoding.UTF8;

@Slf4j
public class ListDemo implements Serializable {

    private static final long serialVersionUID = -794197191018223347L;

    public static void main(String[] args) throws UnsupportedEncodingException {
        String title = "abc这是啥哈哈";
        System.out.println(title.getBytes("GBK").length);
        if (title.getBytes("GBK").length>10){
            title = substring(title, 10, "GBK");
        }
        System.out.println(title);
//        String a1 = "sd";
//        System.out.println("a1.byte[].length:"+a1.getBytes(StandardCharsets.UTF_8).length);
//        System.out.println("a1.length:"+a1.length());
//        byte[] bytes = a1.getBytes(StandardCharsets.UTF_8);
//        String s = new String(Arrays.copyOfRange(bytes, 0, 12), StandardCharsets.UTF_8);
//        System.out.println("s:"+s);

//        String title = "上中国flss";
//        if (null != title){
//            Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");
//            Matcher matcher = pattern.matcher(title);
//            if (matcher.find()){
//                //有中文
//                if (title.getBytes(StandardCharsets.UTF_8).length>45){
//                    title = new String(Arrays.copyOfRange(title.getBytes(StandardCharsets.UTF_8),0,45));
//                }
//            }else{
//                //无中文
//                if (title.length()>30){
//                    title = title.substring(0,30);
//                }
//            }
//        }else{
//            title = "";
//        }
//        System.out.println("title:"+title);


//        byte[] aa = new byte[10];
//        if (bytes.length>10){
//            for (int i = 0; i < 10; i++) {
//                aa[i]=bytes[i];
//            }
//        }
//        String s1 = new String(aa, StandardCharsets.UTF_8);
//        System.out.println(s1);


//        String s = new String(Arrays.copyOfRange(bytes, 0, 11), StandardCharsets.UTF_8);


//        List<String> list1 = new ArrayList<>();
//        list1.add("a");
//        list1.add("aa");
//        list1.add("aaa");
//
//        List<Integer> list2 = new ArrayList<>();
//        list2.add(1);
//        list2.add(2);
//        list2.add(3);
//
//        AtomicBoolean flag = new AtomicBoolean(false);
//        list1.stream().forEach(s -> {
//            list2.stream().forEach(l -> {
//                if (l ==2){
//                    flag.set(true);
//                    return;
//                }
//                System.out.println(s);
//            });
//            if (flag.equals(true)){
//                return;
//            }
//
//        });












//        String msg = "sizemapping:CHK_SIZE_REQUIRED_FIELD_ID_EMPTY:尺码表必填";
//        String newMsg = "";
//        if (msg.contains("CHK_SIZE_REQUIRED_FIELD_ID_EMPTY")){
//            newMsg = msg.replaceAll("最新错误",msg);
//        }
//        System.out.println(newMsg);

//        List<String> aa = new ArrayList<>();
////        aa.add("8486991");
//        if (aa.contains("8486991")){
//            System.out.println("xxx");
//        }
//        TestVo t = new TestVo();
//
        List<User> users = new ArrayList<>();
        User l1U1 = new User("张三",15,"men",true);
        User l1U2 = new User("张三",15,"men",true);
        User l1U3 = new User("李四",16,"men",true);
        User l1U4 = new User("李四",16,"men",true);
        User l1U5 = new User("小芳",12,"women",true);
        User l1U6 = new User("小芳",12,"women",true);
        users.add(l1U1);
        users.add(l1U2);
        users.add(l1U3);
        users.add(l1U4);
        users.add(l1U5);
        users.add(l1U6);
        List<User> needRemove = new ArrayList<>();
        users.stream().forEach(u -> {
            if (u.getName().equals("李四")){
                needRemove.add(u);
            }
        });
//        for (int i = 0; i < users.size(); i++) {
//            if (users.get(i).getName().equals("李四")){
//                users.remove(users.get(i));
//            }
//        }
        users.removeAll(needRemove);
        System.out.println(">>>>>>>>>>>>>>>>>");
        System.out.println(users);
//
//        Map<String, List<User>> collect = users.stream().collect(Collectors.groupingBy(User::getName));
//
////        users.forEach(t::setXx);
////
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


        List<String> cids = Arrays.asList("aa","bb","cc","dd","ee");

        List<List<String>> lists = ListSplitUtil.splitList(cids, 2);
        System.out.println(lists);

    }

    public static String substring(String text, int length, String encode)
            throws UnsupportedEncodingException {
        if (text == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int currentLength = 0;
        for (char c : text.toCharArray()) {
            currentLength += String.valueOf(c).getBytes(encode).length;
            if (currentLength <= length) {
                sb.append(c);
            } else {
                break;
            }
        }
        return sb.toString();
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
