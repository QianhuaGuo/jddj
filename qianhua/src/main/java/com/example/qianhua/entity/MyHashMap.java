package com.example.qianhua.entity;

import java.io.Serializable;

public class MyHashMap<K,V> extends MyAbstractMap<K,V> implements MyMap<K,V>, Serializable {

    @Override
    public boolean isEmpty() {
        return false;
    }
}
