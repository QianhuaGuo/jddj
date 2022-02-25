package com.example.qianhua.jddc.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

public class JdUtilsTest {

    public static void main(String[] args) throws Exception{

        String js = "";
        JSONObject jsonObject = JSONObject.parseObject(js);

        List<String> allList = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        l1.add("a");
        l1.add("b");
        l1.add("c");
        List<String> l2 = new ArrayList<>();
        l2.add("d");
        l2.add("e");
        l2.add("f");
        allList.addAll(l1);
        allList.addAll(l2);
        System.out.println(JSONObject.toJSONString(allList));
        allList.clear();
        System.out.println(allList.size());

        TreeMap<String,Object> tm = new TreeMap<>();
        tm.put("pageNo",1);
        tm.put("pageNo",2);
        System.out.println(JSONObject.toJSONString(tm));

        int count = 101;
        int quotient = count/50;
        if (quotient == 0 || (quotient == 1 && count%50 == 0 )){
            System.out.println("只有一页");
        }else{
            int remainder = count%50;
            int pageCount = 0;
            if (remainder>0){
                pageCount = quotient + 1;
            }else{
                pageCount += quotient;
            }
            for (int i = 1;i<pageCount;i++){
                System.out.println("第"+i+"页");
            }
        }

        Map<String,Object> map = new TreeMap<>();
        map.put("skuId","123456789");
        map.put("stationNo","135792468");
        map.put("price","20");
        map.put("marketPrice","20");
        map.put("fields", Arrays.asList("id","pid","categoryName","categoryLevel","categoryStatus","fullPath"));

        String strMap = JSONObject.toJSONString(map);
        Map<String,String> param = new HashMap<>();
        param.put("app_key","sdfsdf");
        param.put("timestamp","sdkfajdls");
        param.put("v","1.0");
        param.put("jd_param_json",strMap);



        String s = JdUtils.concatParams(param);
        System.out.println(s);

        String sign = JdUtils.getSign(param, "skdfjlskdf");
        System.out.println("sign:"+sign);

        String md5String = MD5Util.getMD5String(sign);
        System.out.println("md5String:"+md5String);

        System.out.println(JSONObject.toJSONString(map));

    }
}
