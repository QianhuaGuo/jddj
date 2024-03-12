package com.example.qianhua.designModel.decoratorModel;

public class RedShapeDecorator extends ShapeDecorator{
    public RedShapeDecorator(Shape decoratorShape) {
        super(decoratorShape);
    }

    @Override
    public void draw(){
        decoratorShape.draw();

        //装饰方法
        this.setRedBorder(decoratorShape);
    }

    public void setRedBorder(Shape decoratorShape) {
        System.out.println("涂上红色");
    }
}
