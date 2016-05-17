package com.decorator2;

/**
 * Decorator pattern allows a user to add new functionality to an existing object without altering its structure. This type of design pattern comes under structural pattern as this pattern acts as a wrapper to existing class.
 * <p/>
 * This pattern creates a decorator class which wraps the original class and provides additional functionality keeping class methods signature intact.
 */
public class DecoratorTest {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape redCircle = new RedShapeDecorator(circle);
        Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("Circle of red border");
        redCircle.draw();

        System.out.println("Rectangle with red border");
        redRectangle.draw();

    }
}
