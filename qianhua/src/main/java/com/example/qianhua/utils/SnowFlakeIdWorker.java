package com.example.qianhua.utils;

import cn.hutool.core.lang.Singleton;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.junit.Test;

import java.sql.SQLOutput;

public class SnowFlakeIdWorker {
    public static void main(String[] args) {
//        System.out.println(2<<2);
//        System.out.println(2>>1);

        for (int i = 0;i<100;i++){
            System.out.println(getId());
        }
    }

    public static long getId(){
        return getSnowflake().nextId();
    }

    public static Snowflake getSnowflake() {
        return Singleton.get(Snowflake.class, new Object[0]);
    }

    @Test
    public void getNextId(){
        for (int i = 0;i<100;i++){
//            System.out.println(getSnowflake().nextId());
            String name =
                    String.format("差异调整单基础信息导出结果_%s.xlsx", Long.toString(IdUtil.getSnowflakeNextId(), 36));
            System.out.println(name);
        }
    }
}
