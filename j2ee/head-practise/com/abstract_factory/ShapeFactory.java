package com.abstract_factory;

public class ShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(IShape e) {
        Shape s = null;
        if (e == IShape.CIRCLE) {
            s = new Circle();
        } else if (e == IShape.SQUARE) {
            s = new Square();
        }
        return s;
    }

    @Override
    public Color getColor(IColor e) {
        return null;
    }
}
