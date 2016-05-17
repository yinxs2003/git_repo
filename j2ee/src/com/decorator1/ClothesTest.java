package com.decorator1;

public class ClothesTest {
    public static void main(String[] args){
        Clothes coat = new Coat();
        //ClothesDecorator本身实现了Clothoes接口，因此可以使用多态
        Clothes redCoat = new RedClothesDecorator(coat);//没有函数，是怎么通过构造方法赋值的？？？
//        coat.dressedUp();
        redCoat.dressedUp();
    }
}
