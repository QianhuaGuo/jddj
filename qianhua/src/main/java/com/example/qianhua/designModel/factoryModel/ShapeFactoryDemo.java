package com.example.qianhua.designModel.factoryModel;

public class ShapeFactoryDemo {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape circle = factory.getShape("circle");
        circle.draw();
    }
}
