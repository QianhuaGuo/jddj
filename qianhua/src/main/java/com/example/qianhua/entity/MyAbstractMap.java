package com.example.qianhua.entity;

public abstract class MyAbstractMap<K,V> implements MyMap<K,V>{

    public int size(){return 1;}

    public boolean isEmpty(){return false;}
}
