package com.abstract_factory;

public abstract class AbstractFactory {
    public abstract Shape getShape(IShape e);

    public abstract Color getColor(IColor e);

}
