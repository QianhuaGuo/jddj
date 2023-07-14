package com.example.qianhua.demo;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.*;

@Data
@EqualsAndHashCode
public class Son1 extends Dad{

    private String name;

    private int age;

    public static String transOperatorId(String operatorId){
        if (operatorId.indexOf("|")>0){
            operatorId = operatorId.substring(operatorId.indexOf("|")+1,operatorId.length());
        }
        return operatorId;
    }

    public static void main(String[] args) {
//        String o = "integration-platform-service_pim-workbench-service_陈俊燕jm032332";
//
//        o = o.substring(o.indexOf("|"),o.length()).replace("|", "");
//
//        System.out.println(o);
//
//        System.out.println(transOperatorId(o));


        Map<String, List<String>> tenantCodeGroup = new HashMap<>();

//        ["wework-jm016169","wework-jm006826"]
        List<String> s = new ArrayList<>();
        s.add("wework-jm016169");
        s.add("wework-jm006826");
        tenantCodeGroup.put("ddc-price-control-sit",s);


            Set<Long> userIds = new HashSet<>();

            userIds.add(100L);
            userIds.add(200L);
            userIds.add(500L);
            userIds.add(600L);
            userIds.add(700L);



            userIds.forEach(u -> {
                if (u.equals(200L)){
                    return;
                }
                System.out.println(u);
            });



//            System.out.println(JSONObject.toJSONString(userIds));

    }
}
