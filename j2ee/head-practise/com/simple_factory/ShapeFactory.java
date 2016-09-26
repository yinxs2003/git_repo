package com.simple_factory;

public enum ShapeFactory {
    CIRCLE, SQUARE;

    public static Shape getShape(ShapeFactory e) {
        Shape s = null;
        if (e == CIRCLE) {
            s = new Circle();
        } else if (e == SQUARE) {
            s = new Square();
        }
        return s;
    }
}
