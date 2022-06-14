package com.example.qianhua.springDemo;

/**
 * 类加载的顺序D->A->C->B->C->B
 * jvm在加载类的时候首先会初始化静态代码块
 * 然后走主方法，在每次创建对象时会先加载代码块
 */
public class ClassLoaderOrderDemo {
    public static void main(String[] args) {
        System.out.println("A");
        new ClassLoaderOrderDemo();
        new ClassLoaderOrderDemo();
    }
    public ClassLoaderOrderDemo(){
        System.out.println("B");
    }
    {
        System.out.println("C");
    }
    static{
        System.out.println("D");
    }
}
