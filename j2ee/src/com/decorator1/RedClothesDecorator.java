package com.decorator1;

public class RedClothesDecorator extends ClothesDecorator {
    public RedClothesDecorator(Clothes decoratedCoat) {
        super(decoratedCoat);
    }
    @Override
    public void dressedUp(){
        chooseColor();

        //decoratedCoat既是父类属性，但被子类构造方法赋值
        decoratedCoat.dressedUp();
    }

    private void chooseColor(){

        System.out.println("color:red");
    }
}
