package com.decorator3;

abstract class ShapeDecorator implements Shape {
    protected Shape decoratorShape;
    ShapeDecorator(Shape decoratorShape){
        this.decoratorShape = decoratorShape;
    }

    @Override
    public void draw(){
        System.out.println("decorate shape");
    }
}
