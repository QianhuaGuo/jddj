package com.example.qianhua.annotation;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.fastjson.JSONObject;
import com.example.qianhua.entity.User;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Testd {

    public static List<List<String>> delHeads(Class<?> clazz) throws NoSuchFieldException, IllegalAccessException{
        Field[] fields = clazz.getDeclaredFields();
        List<List<String>> heads = new ArrayList<>();
        for (int j = 0 ; j<fields.length ; j++){
            Field field = fields[j];
            if (field.isAnnotationPresent(ExcelProperty.class)){
                ExcelProperty prop = field.getAnnotation(ExcelProperty.class);
                String[] value = prop.value();
                List<String> head = new ArrayList<>();
                head.add(value[0]);
                heads.add(head);
            }
        }
        return heads;
    }

//    public static List<List<String>> delHeads(Class<?> clazz) throws NoSuchFieldException, IllegalAccessException{
//        Field[] fields = clazz.getDeclaredFields();
//        List<List<String>> heads = new ArrayList<>();
//        for (int j = 0 ; j<fields.length ; j++){
//            Field field = fields[j];
//            if (field.isAnnotationPresent(ExcelProperty.class)){
//                ExcelProperty prop = field.getAnnotation(ExcelProperty.class);
//                //获取 ExcelProperty 这个代理实例所持有的 InvocationHandler
//                InvocationHandler phandler = Proxy.getInvocationHandler(prop);
//                // 获取 AnnotationInvocationHandler 的 memberValues 字段
//                Field memberValues = phandler.getClass().getDeclaredField("memberValues");
//                // 因为这个字段是 private final 修饰，所以要打开权限
//                memberValues.setAccessible(true);
//                // 获取 memberValues
//                Map i18nValues = (Map) memberValues.get(phandler);
//                String[] value = prop.value();
//                List<String> head = new ArrayList<>();
//                head.add(value[0]);
//                heads.add(head);
//            }
//        }
//        return heads;
//    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException, InstantiationException {
//        List<List<String>> lists = delHeads(CustomerSkuSortData.class);
//        String ss = "\\%\\*";
//        System.out.println(ss);
//
//
//        String aa = "aa.bb.vc.ssdf.sdf";
//        String[] split = aa.split("\\.");
//        System.out.println(JSONObject.toJSONString(split));
        User u = new User();
        Class<?> aClass = Class.forName("com.example.qianhua.entity.User");
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(u,"huazzzz");


        System.out.println(0);

    }
}
