package com.example.qianhua.designModel.decoratorModel;

/**
 *
 */
public class DecoratorModelDemo {
    public static void main(String[] args) {
        Shape circle = (Shape) new Circle();
        Shape redCircle = new RedShapeDecorator((Shape) new Circle());
        Shape redRectangle = new RedShapeDecorator((Shape) new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();
        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
