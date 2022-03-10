package com.example.qianhua.abstractde;

import com.google.common.collect.Lists;
import lombok.Data;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class Train extends CarAbstract{
    private String carname;

    public Train(Integer wheels, String type) {
        super(wheels, type);
    }

    @Override
    public void howRun() {
        System.out.println("在铁轨上行驶");
    }

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        Date time = new Date();
        System.out.println(LocalDateTime.now());
        System.out.println(time);
        List<String> s = Lists.newArrayList();
        s.add("a");
        s.add("aa");
        s.add("aaa");
        s.add("aaaa");
        s.add("aaaaa");
        s.forEach(a -> {
            String b = a;
            System.out.println(a);
        });
    }

}
