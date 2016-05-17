package com.decorator1;

public class RedClothesDecorator extends CoatDecorator{
    public RedClothesDecorator(Clothes decoratedCoat) {
        super(decoratedCoat);
    }
    @Override
    public void dressedUp(){
        decoratedCoat.dressedUp();
        chooseColor();
    }

    private void chooseColor(){

        System.out.println("color:red");
    }
}
