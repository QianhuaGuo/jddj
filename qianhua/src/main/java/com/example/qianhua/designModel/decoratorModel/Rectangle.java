package com.example.qianhua.designModel.decoratorModel;

import com.example.qianhua.designModel.factoryModel.Shape;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("画了个矩形");
    }
}
