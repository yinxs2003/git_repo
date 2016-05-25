package com.decorator2;

class RedShapeDecorator extends ShapeDecorator {

    RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        decoratedShape.draw();
        System.out.println("Border Color:red");
    }
}
