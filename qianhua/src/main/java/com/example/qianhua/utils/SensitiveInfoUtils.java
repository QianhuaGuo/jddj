package com.example.qianhua.utils;


import org.apache.commons.lang3.StringUtils;

/**
 * 敏感信息处理
 */
public class SensitiveInfoUtils {

    /**
     * 姓名：只保留第一个字，其余屏蔽，如“张**”
     * @param originalStr
     * @return
     */
    public static String name(String originalStr){
        if (StringUtils.isBlank(originalStr)){
            return originalStr;
        }
        if (originalStr.length() < 2){
            return originalStr + "*";
        }
        return StringUtils.rightPad(originalStr.substring(0,1), originalStr.length(), "*");
    }

    /**
     * 手机：保留后四位，其余屏蔽，如“*******2222”
     * @param originalStr
     * @return
     */
    public static String mobile(String originalStr){
        if (StringUtils.isBlank(originalStr)){
            return originalStr;
        }
        if (originalStr.length() < 5){
            return "*" + originalStr;
        }
        return StringUtils.leftPad(originalStr.substring(originalStr.length() - 4), originalStr.length(), "*");
    }

    /**
     * 电话：只保留前三位，其余屏蔽
     * @param originalStr
     * @return
     */
    public static String phone(String originalStr){
        if (StringUtils.isBlank(originalStr)){
            return originalStr;
        }
        if (originalStr.length() < 5){
            return "*" + originalStr;
        }
        return StringUtils.leftPad(originalStr.substring(originalStr.length() - 4), originalStr.length(), "*");
    }

    /**
     * 详细地址：只保留前三个字，其余屏蔽
     * @param originalStr
     * @return
     */
    public static String address(String originalStr){
        if (StringUtils.isBlank(originalStr)){
            return originalStr;
        }
        if (originalStr.length() < 4){
            return originalStr + "*";
        }
        return StringUtils.rightPad(originalStr.substring(0, 3), originalStr.length(), "*");
    }

    /**
     * 银行账户：只保留前三位，其余屏蔽
     * @param originalStr
     * @return
     */
    public static String bankAcc(String originalStr){
        if (StringUtils.isBlank(originalStr)){
            return originalStr;
        }
        if (originalStr.length() < 4){
            return originalStr + "*";
        }
        return StringUtils.rightPad(originalStr.substring(0,3), originalStr.length(), "*");
    }

    public static void main(String[] args){
        String result = name("zhange");
        System.out.println(result);
        result = name("1");
        System.out.println(result);
        result = name("");
        System.out.println(result);
        result = name(null);
        System.out.println(result);
        result = mobile("13451627344");
        System.out.println(result);
        result = phone("0201");
        System.out.println(result);
        result = phone("2316788765");
        System.out.println(result);
        result = address("上海十九世纪十九世纪十九世纪");
        System.out.println(result);
        result = address("上海十");
        System.out.println(result);
        result = bankAcc("62253518441554744455");
        System.out.println(result);
        result = bankAcc("622");
        System.out.println(result);
    }
}
