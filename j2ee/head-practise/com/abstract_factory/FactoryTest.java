package com.abstract_factory;

public class FactoryTest {
    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
        Shape c = shapeFactory.getShape(IShape.CIRCLE);
        c.draw();
    }
}
