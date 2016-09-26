package com.abstract_factory;

public class ColorFactory extends AbstractFactory {
    @Override
    public Shape getShape(IShape e) {
        return null;
    }

    @Override
    public Color getColor(IColor e) {
        Color c = null;
        if (e == IColor.RED) {
            c = new Red();
        } else if (e == IColor.BLUE) {
            c = new Blue();
        } else if (e == IColor.GREEN) {
            c = new Green();
        }
        return c;
    }
}
