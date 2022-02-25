package com.example.qianhua.jddc.util;

import o2o.openplatform.sdk.util.MD5Util;

import java.util.*;

public class JdUtils {

    public static String concatParams(Map<String, String> params2) {
        Object[] key_arr = params2.keySet().toArray();
        Arrays.sort(key_arr);
        StringBuilder str = new StringBuilder();
        for (Object key : key_arr) {
            String val = params2.get(key);
            str.append(key).append(val);
        }
        return str.toString();
    }

    public static String getSign(Map<String,String> param,String appSecret ) throws Exception{
        String sysStr=concatParams(param);
        StringBuilder resultStr=new StringBuilder();
        resultStr.append(appSecret).append(sysStr).append(appSecret);
        return MD5Util.getMD5String(resultStr.toString()).toUpperCase();
    }
}
