package com.decorator1;

class RedClothesDecorator extends ClothesDecorator {
    RedClothesDecorator(Clothes decoratedCoat) {
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
