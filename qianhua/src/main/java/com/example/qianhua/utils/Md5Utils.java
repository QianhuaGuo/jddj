package com.example.qianhua.utils;

import com.alibaba.fastjson.JSONObject;
import com.example.qianhua.entity.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Md5Utils {

    public static void main(String[] args) {
        User u1 = new User("话",12,"男");
        User u2 = new User("话",12,"男");
        User u3 = new User("话",11,"男");

        System.out.println(md5(JSONObject.toJSONString(u1)));
        System.out.println(md5(JSONObject.toJSONString(u2)));
        System.out.println(md5(JSONObject.toJSONString(u3)));
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);



        Optional.ofNullable(list).ifPresent(wmInCartonList1 -> {
//            wmInCartonList1.forEach(wmInCarton -> {
//
//            });
        });

    }


    // MD5加密方法
    public static String md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
}
