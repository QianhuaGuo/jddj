package com.example.qianhua.spi;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.ServiceLoader;

public class SpiTest {
    public static void main(String[] args) {
        HashMap<String,Object> h = new LinkedHashMap();
        ServiceLoader<Register> loader = ServiceLoader.load(Register.class);
        Iterator<Register> iterator = loader.iterator();
        while (iterator.hasNext()){
            Register next = iterator.next();
            next.register("182.2.13.0","8888");
        }
    }
}
