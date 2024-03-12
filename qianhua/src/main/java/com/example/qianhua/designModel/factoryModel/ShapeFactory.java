package com.example.qianhua.designModel.factoryModel;

public class ShapeFactory {
    public Shape getShape(String type){
        if ("circle".equals(type)){
            return new Circle();
        }else{
            return new Rectangle();
        }
    }
}
