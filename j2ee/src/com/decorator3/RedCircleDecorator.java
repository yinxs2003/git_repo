package com.decorator3;

public class RedCircleDecorator extends ShapeDecorator {
    RedCircleDecorator(Shape decoratorShape) {
        super(decoratorShape);
    }

    @Override
    public void draw() {
        //画个图形
        decoratorShape.draw();
        //设置边框颜色
        setBorder();
    }

    private void setBorder() {
        System.out.println("border: red");
    }
}
