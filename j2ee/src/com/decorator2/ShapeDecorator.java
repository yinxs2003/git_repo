package com.decorator2;

/**
 * <li>装饰器也是继承Shape接口</li>
 * <li>有一个受保护成员变量</li>
 */
public class ShapeDecorator implements Shape{

    //protected对其他包访问关闭
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}
