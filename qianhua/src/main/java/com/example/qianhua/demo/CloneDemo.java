package com.example.qianhua.demo;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.qianhua.entity.User;

import java.util.ArrayList;
import java.util.List;

public class CloneDemo {

    public static void main(String[] args) {

        CloneEntity user = new CloneEntity("jj",18,"men");
        CloneEntity user1 = new CloneEntity("jj",18,"men");
        user.equals(user1);
        List<User> users = new ArrayList<>();
        users.add(new User("aa",12,"women"));
        user.setUserList(users);

        System.out.println(JSONObject.toJSONString(user));
        System.out.println(JSONObject.toJSONString(user1, SerializerFeature.WriteNullListAsEmpty));
//
//        CloneEntity clone = ObjectUtil.clone(user);
//        CloneEntity cloneByStream = ObjectUtil.cloneByStream(user);
//
//        System.out.println(user.equals(clone));
//        System.out.println(user.equals(cloneByStream));
//
//        System.out.println(clone);
//        System.out.println(cloneByStream);

    }
}
