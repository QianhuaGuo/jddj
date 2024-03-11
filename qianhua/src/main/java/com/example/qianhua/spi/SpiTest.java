package com.example.qianhua.spi;

import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.*;

public class SpiTest {
    public static void main(String[] args) {
        HashMap<String,Object> h = new LinkedHashMap();
        //方法1 利用spring的SPI机制：SpringFactoriesLoader.loadFactories,在META-INF创建spring.factories文件写入接口的全限定名称=实现类的全限定名称，多个用逗号隔开
//        List<Register> registers = SpringFactoriesLoader.loadFactories(Register.class, null);
//        for (Register register : registers) {
//            register.register("182.2.13.0","8888");
//        }

        //方法2 使用JDK自带的SPI机制，ServiceLoader.load加载接口实现类，在META-INF下的services文件中创建接口的全限定名称文件，里面写接口实现类的全限定名称
        ServiceLoader<Register> loader = ServiceLoader.load(Register.class);
        Iterator<Register> iterator = loader.iterator();
        while (iterator.hasNext()){
            Register next = iterator.next();
            next.register("182.2.13.0","8888");
        }
    }
}
