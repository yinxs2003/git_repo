package com.prototype;

public class Square extends Shape {
    public Square() {
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }


}
