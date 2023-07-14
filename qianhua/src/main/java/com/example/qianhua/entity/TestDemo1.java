package com.example.qianhua.entity;

import com.alibaba.fastjson.JSONObject;
import com.example.qianhua.exception.BizException;
import com.mchange.v1.util.ListUtils;
import org.springframework.util.StopWatch;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class TestDemo1 {

    public static void main(String[] args) throws ParseException {




        String tu1 = "123.jpg";
//        String tu1 = "asdf_dsf_1.jpg";

        Integer sort =null;
        System.out.println(sort);
        boolean contains = tu1.contains(".");
        if (contains){
            if (tu1.contains("_")){
                sort = Integer.valueOf(tu1.substring(tu1.lastIndexOf("_")+1, tu1.lastIndexOf(".")));
            }else{
                sort = Integer.valueOf(tu1.substring(0, tu1.lastIndexOf(".")));
            }
        }else{
            if (!tu1.contains("_")){
                sort = Integer.valueOf(tu1);
            }
        }

        System.out.println(sort);


        Long a = 2147483649L;
        int i = a.intValue();
        System.out.println(i);

            String s = "ra:DATE:2021-12-20 15:50:21,DATE:2022-01-06 10:15:40";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String[] split = s.split(",");
            Date startTime = sdf.parse(split[0].substring(split[0].indexOf("DATE:")+5));
            Date endTime = sdf.parse(split[1].substring(split[1].indexOf("DATE:")+5));

        List<User> users = new ArrayList<>();
        User l1U1 = new User("张三",15,"men",true);
        User l1U2 = new User("李四",16,"men",true);
        User l1U3 = new User("小芳",12,"women",true);
        users.add(l1U1);
        users.add(l1U2);
        users.add(l1U3);


        System.out.println(JSONObject.toJSONString(users));
        StopWatch stopWatch = new StopWatch("test");
        stopWatch.start("compare");
        users.sort((o1, o2) -> {
            Integer age1 = o1.getAge();
            Integer age2 = o2.getAge();
            return age1.compareTo(age2);
        });
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        System.out.println(JSONObject.toJSONString(users));

        try{
            if (users.stream().allMatch(aa -> aa.getIsStudent())){
                throw new BizException("自定义错误数据!");
//                System.out.println("全是true");
            }else{
                System.out.println("有false");
            }
        }catch (Exception ex){
            System.out.println("sdfsdf"+ex.getMessage());
        }


    }
}
