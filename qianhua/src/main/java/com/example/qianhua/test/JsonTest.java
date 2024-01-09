package com.example.qianhua.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.qianhua.entity.User;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Data
public class JsonTest {

    private List<String> name;
    private List<String> code;

    public static void main(String[] args) {

        JSONObject j1 = new JSONObject();
        j1.put("name","ceshi1.mp4");
        j1.put("originalDamUrl","httaps://scm-dam.oss-cn-shanghai.aliyuncs.com/scm-dam/2023-11-09/TEST视频(377)_38d9a88d-8ce6-4192-912e-119f96b705b9.mp4");
        j1.put("url","shttps://scm-dam-oss-cn-cdn2.baozun.com/scm-dam/2023-09-05/t1_330d44f8-d72f-4633-a72c-a5d16573d7c8.png");


        JSONObject j2 = new JSONObject();
        j2.put("name","ceshi1.mp4");
        j2.put("originalDamUrl","https://scm-dam.oss-cn-shanghai.aliyuncs.com/scm-dam/2023-11-09/TEST视频(377)_38d9a88d-8ce6-4192-912e-119f96b705b9.mp4");
        j2.put("url","shttps://scm-dam-oss-cn-cdn2.baozun.com/scm-dam/2023-09-05/t1_330d44f8-d72f-4633-a72c-a5d16573d7c8.png");

        boolean both = j1.equals(j2);
        if(both){
            System.out.println("相同");
        }else{
            System.out.println("不相同");
        }

        System.out.println("============================================================");
        List<String> levelList = Arrays.asList("GAP", "女装", "", "T恤/背心").stream().filter(StringUtils::isNotBlank).collect(Collectors.toList());
        System.out.println(JSONObject.toJSONString(levelList));

        List<String> nameList = Arrays.asList("aa","bb","cc");
        List<String> codeList = Arrays.asList("dd","ee","ff");
        JsonTest jt = new JsonTest();
        jt.setCode(codeList);
        jt.setName(nameList);

        TreeSet treeSet = new TreeSet();

        System.out.println(JSONObject.toJSONString(jt));

        System.out.println("++++++++++++++++++++++++++++++++");

        SearchVo sv = new SearchVo();
        sv.setSearchParam(JSONObject.toJSONString(jt));
        System.out.println(sv.getSearchParam());

        JsonTest jt2 = new JsonTest();
        JSONObject jsonObject = JSONObject.parseObject(sv.getSearchParam());
        jt2.setName((List<String>) jsonObject.get("name"));
        jt2.setCode((List<String>) jsonObject.get("code"));



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
