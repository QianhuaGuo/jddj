package com.example.qianhua.entity;

import java.lang.reflect.Constructor;

/**
 * 枚举类实现单例，线程安全，序列化和反序列化正常
 */
public class SingtonDemo {
    private SingtonDemo(){}

    public static SingtonDemo getInstance(){
        return SingtonHolder.INSTANCE.getInstance();
    }

    public static SingtonHolder gete(){
        return SingtonHolder.INSTANCE;
    }

    private enum SingtonHolder{
        INSTANCE;

        private final SingtonDemo singtonDemo;

        SingtonHolder() {
            this.singtonDemo = new SingtonDemo();
        }

        private SingtonDemo getInstance(){
            return singtonDemo;
        }
    }

    public static void main(String[] args) throws Exception {
        SingtonDemo instance1 = SingtonDemo.getInstance();
        SingtonDemo instance2 = SingtonDemo.getInstance();
        System.out.println(instance2 == instance1);
        //无法获取上面设置的无参数构造器，此处不能通过反射构造出新的对象
        Constructor<SingtonHolder> constructor = SingtonHolder.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingtonHolder singtonHolder = constructor.newInstance();
        SingtonDemo instance3 = singtonHolder.getInstance();
        SingtonDemo instance4 = singtonHolder.getInstance();
        System.out.println(instance3 == instance4);
    }
}
