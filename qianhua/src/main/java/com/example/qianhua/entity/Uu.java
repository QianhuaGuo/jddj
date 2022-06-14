package com.example.qianhua.entity;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Uu {

    public static void main(String[] args) {
        List list = (List) Collections.synchronizedCollection(new LinkedList<>());
    }
}
