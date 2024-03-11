package com.example.qianhua.proxy.jdkProxyDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;

public class PorxyDemo01 {
    private String name;
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        HashMap hm = new HashMap();
//        hm.put(null,null);
//        hm.get(null);
//
//        Hashtable ht = new Hashtable();
//        ht.put("a","b");
//        ht.get("a");

        TreeMap tm = new TreeMap();
        tm.put("a",null);

        StringBuffer sb = new StringBuffer();
        sb.append("a");
        System.out.println(sb);

        StringBuilder sbu = new StringBuilder();
        sbu.append("a");

        System.out.println(HelloService.class.getModifiers());
        System.out.println(PorxyDemo01.class.getModifiers());
        Constructor<PorxyDemo01> constructor = PorxyDemo01.class.getConstructor(null);
        System.out.println(constructor);
        int modifiers = constructor.getModifiers();
        System.out.println(modifiers);
        PorxyDemo01 porxyDemo01 = constructor.newInstance(null);
    }
}
