package com.decorator3;

public class DecoratorTest {
    public static void main(String[] args){
        Shape circle = new Circle();
        Shape redCircle = new RedCircleDecorator(circle);
        redCircle.draw();
    }
}
