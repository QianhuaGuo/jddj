package com.example.qianhua.entity;

import com.example.qianhua.annotation.NumberCheck;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class CheckHh {

    @NotNull(message = "名称不能为空")
    private String name;

    private String nickName;

    @NumberCheck(message = "年龄不能小于0")
    private Integer age;

    public static void main(String[] args) {
//        String property = System.getProperty("java.version");
//        System.out.println(property);

//        Properties properties = System.getProperties();
//        for (String key : properties.stringPropertyNames()){
//            System.out.println(key + ": " + properties.getProperty(key));
//        }
//        Lock lock = new ReentrantLock();
//        CheckHh ch = new CheckHh();
//        Class<? extends CheckHh> aClass = ch.getClass();
//        System.out.println("name:"+aClass.getName());
//        System.out.println("simpleName:"+aClass.getSimpleName());
//        System.out.println("canonical:"+aClass.getCanonicalName());
//        System.out.println("typeName:"+aClass.getTypeName());
//        System.out.println(aClass);

        List<String> list = Arrays.asList("a","b","c","d","e","f");
        Iterator<String> iterator = list.stream().iterator();
        if (iterator.hasNext()){
            if (iterator.next().equals("b")){
                iterator.remove();
            }
        }
        System.out.println(list);

    }
}
