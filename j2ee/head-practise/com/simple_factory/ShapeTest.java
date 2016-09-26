package com.simple_factory;

public class ShapeTest {
    public static void main(String[] args) {
        Shape s = ShapeFactory.getShape(ShapeFactory.CIRCLE);
        s.draw();

        s = ShapeFactory.getShape(ShapeFactory.SQUARE);
        s.draw();
    }
}
